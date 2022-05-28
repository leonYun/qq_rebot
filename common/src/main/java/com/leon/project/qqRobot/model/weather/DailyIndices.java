package com.leon.project.qqRobot.model.weather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * https://dev.qweather.com/docs/api/indices/
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DailyIndices {
    /**
     * 时间 yyyy-MM-dd
     */
    private String date;

    /**
     * type 生活指数类型
     * https://dev.qweather.com/docs/resource/indices-info/
     */
    private Integer type;

    /**
     * 生活指数类型名称
     */
    private String name;

    /**
     * 生活指数预报等级
     * https://dev.qweather.com/docs/resource/indices-info/
     */
    private Integer level;

    /**
     * 生活指数预报级别
     */
    private String category;

    /**
     * 生活指数预报详细描述
     */
    private String text;
}
