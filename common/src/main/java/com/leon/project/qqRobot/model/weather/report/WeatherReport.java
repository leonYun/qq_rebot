package com.leon.project.qqRobot.model.weather.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherReport {
    private String nickname;

    /**
     * 早上、中午、晚上
     */
    private String timeQuantum;

    private String currentTime;

    private String address;

    private String weather;

    private String icon;

    private String temp;

    private String feelsLike;

    private String humidity;

    private String windDir;

    private String windScale;

    private String dailyIndicesStr;
}
