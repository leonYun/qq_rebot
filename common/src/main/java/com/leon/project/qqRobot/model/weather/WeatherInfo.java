package com.leon.project.qqRobot.model.weather;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * https://dev.qweather.com/docs/api/weather/weather-now/
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherInfo {
    /**
     * 观测时间
     */
    private String obsTime;

    /**
     * 温度 默认摄氏度
     */
    private String temp;

    /**
     * 体感温度
     */
    private String feelsLike;

    /**
     *  天气描述
     */
   private String text;

    /**
     * 风向
     */
    private String windDir;

    /**
     * 风力等级
     */
    private Integer windScale;

    /**
     * 风速 公里/小时
     */
    private Integer windSpeed;

    /**
     * 相对湿度
     */
    private String humidity;

    /**
     * 当前小时累计降水量 毫米
     */
    private Integer precip;

    /**
     * 大气压强 百p
     */
    private Integer pressure;

    /**
     * 能见度 公里
     */
    private Integer vis;

    /**
     * 露天温度
     */
    private Integer dew;
}

