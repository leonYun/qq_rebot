package com.leon.project.qqRobot.service.service.weather;

import com.leon.project.qqRobot.model.weather.DailyIndices;
import com.leon.project.qqRobot.model.weather.WeatherInfo;
import com.leon.project.qqRobot.model.weather.WeatherWarning;

import java.util.List;

public interface WeatherService {
    WeatherInfo getCurrentWeatherInfo(String address);

    List<DailyIndices> getDailyIndices(String address);

    List<WeatherWarning> getWeatherWarning(String address);
}
