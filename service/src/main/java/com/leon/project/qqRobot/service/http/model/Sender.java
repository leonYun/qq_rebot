package com.leon.project.qqRobot.service.http.model;

import lombok.Data;

@Data
public class Sender {
    /**
     * 发送者qq号
     */
    private String userId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 群名片/备注
     */
    private String card;

    /**
     * 性别 male female unknown
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地区
     */
    private String area;

    /**
     * 成员等级
     */
    private String level;

    /**
     * 角色 owner admin member
     */
    private String role;

    /**
     * 专属头衔
     */
    private String title;
}

