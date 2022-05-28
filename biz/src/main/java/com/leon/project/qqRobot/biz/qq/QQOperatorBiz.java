package com.leon.project.qqRobot.biz.qq;

import com.leon.project.qqRobot.biz.weather.WeatherBiz;
import com.leon.project.qqRobot.model.weather.DailyIndices;
import com.leon.project.qqRobot.model.weather.WeatherInfo;
import com.leon.project.qqRobot.model.weather.WeatherWarning;
import com.leon.project.qqRobot.model.weather.report.WeatherReport;
import com.leon.project.qqRobot.service.http.model.QQUserInfo;
import com.leon.project.qqRobot.service.service.model.QQUserConfig;
import com.leon.project.qqRobot.service.service.model.QQWarningRecord;
import com.leon.project.qqRobot.service.service.qq.QQOperatorService;
import com.leon.project.qqRobot.service.service.repository.QQWarningRecordRepository;
import com.leon.project.qqRobot.utils.DateUtil;
import com.leon.project.qqRobot.utils.Safes;
import com.leon.project.qqRobot.utils.TemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class QQOperatorBiz {
    @Resource
    private QQOperatorService qqOperatorService;

    @Resource
    private WeatherBiz weatherBiz;

    @Resource
    private QQWarningRecordRepository qqWarningRecordRepository;


    public void sendCurrentWeatherMsg(QQUserConfig receiveUser) {
        Assert.notNull(receiveUser, "接收人不能为空");
        WeatherInfo currentWeatherInfo = weatherBiz.getCurrentWeatherInfo(receiveUser.getAddress());
        QQUserInfo qqInfo = qqOperatorService.getQQInfo(receiveUser.getQq());
        List<DailyIndices> dailyIndices = weatherBiz.getDailyIndices(receiveUser.getAddress());
        qqOperatorService.sendPrivateMsg(buildWeatherInfoMessage(currentWeatherInfo, receiveUser.getAddress(), qqInfo.getNickname(), dailyIndices), receiveUser.getQq());
    }

    private String buildWeatherInfoMessage(WeatherInfo weatherInfo, String address, String nickname, List<DailyIndices> dailyIndices) {
        WeatherReport weatherReport = WeatherReport.builder()
                .address(address)
                .nickname(nickname)
                .weather(weatherInfo.getText())
                .currentTime(DateUtil.parseToStandTimeStr(weatherInfo.getObsTime()))
                .feelsLike(weatherInfo.getFeelsLike())
                .temp(weatherInfo.getTemp())
                .timeQuantum(TemplateUtils.getTimeQuantum())
                .windDir(weatherInfo.getWindDir())
                .humidity(weatherInfo.getHumidity())
                .windScale(String.valueOf(weatherInfo.getWindScale()))
                .icon(TemplateUtils.getIcon(weatherInfo.getText()))
                .dailyIndicesStr(TemplateUtils.getDailyIndices(dailyIndices))
                .build();
        return TemplateUtils.getWeatherReport(weatherReport);
    }

    public void sendWeatherWarning(QQUserConfig receiveUser, WeatherWarning weatherWarning) {
        Assert.notNull(receiveUser, "接收人不能为空");
        Assert.notNull(weatherWarning, "预警信息不能为空");
        QQWarningRecord qqWarningRecords = qqWarningRecordRepository.findByWarningIdAndQqUserId(weatherWarning.getId(), receiveUser.getId());
        if (Objects.nonNull(qqWarningRecords)) {
            return ;
        }
        qqOperatorService.sendPrivateMsg(TemplateUtils.getWeatherWarning(weatherWarning), receiveUser.getQq());
        qqWarningRecordRepository.save(QQWarningRecord.builder()
                        .warningId(weatherWarning.getId())
                        .qqUserId(receiveUser.getId())
                .build());
    }

    public void sendWeatherWarning(QQUserConfig receiveUser) {
        Assert.notNull(receiveUser, "接收人不能为空");
        List<WeatherWarning> weatherWarnings = weatherBiz.getWeatherWaring(receiveUser.getAddress());
        Safes.of(weatherWarnings).forEach(weatherWarning -> {
            try {
                sendWeatherWarning(receiveUser, weatherWarning);
            } catch (Exception e) {
                log.error("发送灾祸数据时出错了", e);
            }
        });
    }

}
