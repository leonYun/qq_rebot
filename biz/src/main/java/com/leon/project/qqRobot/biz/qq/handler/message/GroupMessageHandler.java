package com.leon.project.qqRobot.biz.qq.handler.message;

import com.leon.project.qqRobot.biz.qq.handler.EventHandler;
import com.leon.project.qqRobot.enums.MessageType;
import com.leon.project.qqRobot.service.http.model.QQEventMsg;

@MessageHandlerRegister(MessageType.GROUP)
public class GroupMessageHandler implements EventHandler {
    @Override
    public void handle(QQEventMsg qqEventMsg) {

    }
}
