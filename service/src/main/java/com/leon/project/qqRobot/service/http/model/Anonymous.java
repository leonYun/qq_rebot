package com.leon.project.qqRobot.service.http.model;

import lombok.Data;

@Data
public class Anonymous {
    /**
     * 匿名用户id
     */
    private String id;
    /**
     * 匿名用户名称
     */
    private String name;

    /**
     * 匿名用户flag
     */
    private String flag;
}
