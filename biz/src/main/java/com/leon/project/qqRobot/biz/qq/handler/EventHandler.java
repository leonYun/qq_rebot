package com.leon.project.qqRobot.biz.qq.handler;

import com.leon.project.qqRobot.service.http.model.QQEventMsg;

/**
 * @see com.leon.project.qqRobot.enums.MessageType
 */
public interface EventHandler {
    void handle(QQEventMsg qqEventMsg);
}
