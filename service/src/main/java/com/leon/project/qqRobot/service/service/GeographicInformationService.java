package com.leon.project.qqRobot.service.service;

import com.leon.project.qqRobot.service.http.client.appService.CommonUtilHttpClient;
import com.leon.project.qqRobot.service.http.contanst.VariableConstant;
import com.leon.project.qqRobot.service.service.model.GeographicInformation;
import com.leon.project.qqRobot.service.service.repository.GeographicInformationRepository;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

@Service
public class GeographicInformationService {

    @Resource
    private GeographicInformationRepository geographicInformationRepository;

    @Resource
    private CommonUtilHttpClient commonUtilHttpClient;

    @SneakyThrows
    public GeographicInformation getOrLoadGeoCoder(String address) {
        GeographicInformation geographicInformation = geographicInformationRepository.findByAddress(address);
        if (Objects.nonNull(geographicInformation)) {
            return geographicInformation;
        }

        Map geoCoder = commonUtilHttpClient.getGeoCoder(address);
        String lng = String.valueOf(PropertyUtils.getProperty(geoCoder, VariableConstant.ResponseParser.GEO_CODER_LNG));
        String lat = String.valueOf(PropertyUtils.getProperty(geoCoder, VariableConstant.ResponseParser.GEO_CODER_LAT));

        return geographicInformationRepository.save(GeographicInformation.builder()
                .address(address)
                .lng(lng)
                .lat(lat)
                .build());
    }
}
