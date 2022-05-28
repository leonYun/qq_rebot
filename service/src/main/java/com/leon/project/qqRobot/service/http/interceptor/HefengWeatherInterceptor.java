package com.leon.project.qqRobot.service.http.interceptor;

import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.interceptor.Interceptor;
import com.dtflys.forest.reflection.ForestMethod;
import com.leon.project.qqRobot.service.http.contanst.VariableConstant;
import com.leon.project.qqRobot.service.service.GeographicInformationService;
import com.leon.project.qqRobot.service.service.model.GeographicInformation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class HefengWeatherInterceptor implements Interceptor<String> {

    @Resource
    private GeographicInformationService geographicInformationService;

    @Override
    public void onInvokeMethod(ForestRequest request, ForestMethod method, Object[] args) {
        String address = String.valueOf(request.getQuery(VariableConstant.Param.ADDRESS));
        request.removeQuery(VariableConstant.Param.ADDRESS);

        GeographicInformation geoCoder = geographicInformationService.getOrLoadGeoCoder(address);

        request.getQuery().put(VariableConstant.Param.LOCATION, StringUtils.join(geoCoder.getLng(), ",", geoCoder.getLat()));
    }
}
