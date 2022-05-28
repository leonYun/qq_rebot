package com.leon.project.qqRobot.model.weather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * https://dev.qweather.com/docs/api/warning/weather-warning/
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherWarning {
    /**
     * 预警id
     */
    private String id;

    /**
     * 预警单位
     */
    private String sender;

    /**
     * 预警title
     */
    private String title;

    /**
     * 发布时间
     */
    private Date pubTime;

    /**
     * 预警开始时间
     */
    private Date startTime;

    /**
     * 预警结束时间
     */
    private Date endTime;

    /**
     * 预警状态
     * Active - 当前预警处于激活状态
     * Update - 当前预警是一次对之前指定预警信息的升级或修改
     * Cancel - 由于各种原因取消之前指定预警信息的发布。该状态是一个预保留的值，你目前不能使用这个值去判断预警是否有效
     */
    private String status;

    /**
     * 预警等级
     * 一般来说，颜色越深，代表预警的严重程度越高，目前使用的颜色包括：
     * 白色
     * 蓝色
     * 绿色
     * 黄色
     * 橙色
     * 红色
     * 黑色
     */
    private String level;

    /**
     * 预警类型
     * https://dev.qweather.com/docs/resource/warning-info/#warning-type
     */
    private String type;

    /**
     * 预警类型名称
     */
    private String typeName;

    /**
     * 预警的紧迫程度
     * https://dev.qweather.com/docs/resource/warning-info/#urgency
     * 可能为空
     * Immediate
     * Expected
     * Future
     * Past
     * Unknown
     */
    private String urgency;

    /**
     * 预警信息的准确性
     */
    private String certainty;

    /**
     * 预警详细文字描述
     */
    private String text;

    /**
     * 与本条预警相关联的预警ID，当预警状态为cancel或update时返回。
     * 可能为空
     */
    private String related;
}
