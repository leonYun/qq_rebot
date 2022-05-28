package com.leon.project.qqRobot.service.service.weather;

import com.leon.project.qqRobot.model.weather.DailyIndices;
import com.leon.project.qqRobot.model.weather.WeatherInfo;
import com.leon.project.qqRobot.model.weather.WeatherWarning;
import com.leon.project.qqRobot.service.http.client.appService.WeatherHttpClient;
import com.leon.project.qqRobot.service.http.contanst.VariableConstant;
import com.leon.project.qqRobot.utils.PropertyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HefengWeatherService implements WeatherService{

    @Resource
    private WeatherHttpClient weatherHttpClient;

    @Override
    public WeatherInfo getCurrentWeatherInfo(String address) {
        Map currentWeather = weatherHttpClient.getHefengWeatherCurrentWeather(address);
        return PropertyUtil.getPropertyAsClazz(currentWeather, VariableConstant.ResponseParser.NOW, WeatherInfo.class);
    }

    @Override
    public List<DailyIndices> getDailyIndices(String address) {
        Map currentWeather = weatherHttpClient.getHefengDailyIndices(address);
        return PropertyUtil.getPropertyAsList(currentWeather, VariableConstant.ResponseParser.DAILY, DailyIndices.class);
    }

    @Override
    public List<WeatherWarning> getWeatherWarning(String address) {
        Map currentWeather = weatherHttpClient.getHefengWeatherWaring(address);
        return PropertyUtil.getPropertyAsList(currentWeather, VariableConstant.ResponseParser.WARNING, WeatherWarning.class);
    }
}
