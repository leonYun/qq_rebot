package com.leon.project.qqRobot.service.http.model;

import lombok.Data;

@Data
public class QQUserInfo {
    private String userId;

    private String nickname;

    private String sex;

    private Integer age;

    private String qid;

    private Integer level;

    private Integer loginDays;
}
