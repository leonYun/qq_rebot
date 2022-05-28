package com.leon.project.qqRobot.biz.weather;

import com.leon.project.qqRobot.model.weather.DailyIndices;
import com.leon.project.qqRobot.model.weather.WeatherInfo;
import com.leon.project.qqRobot.model.weather.WeatherWarning;
import com.leon.project.qqRobot.service.service.weather.WeatherService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WeatherBiz {

    @Resource
    private WeatherService weatherService;


    public WeatherInfo getCurrentWeatherInfo(String address) {
        Assert.hasLength(address, "地址不能为空");
        return weatherService.getCurrentWeatherInfo(address);
    }

    public List<WeatherWarning> getWeatherWaring(String address) {
        Assert.hasLength(address, "地址不能为空");
        return weatherService.getWeatherWarning(address);
    }

    public List<DailyIndices> getDailyIndices(String address) {
        return weatherService.getDailyIndices(address);
    }
}
