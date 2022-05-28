package com.leon.project.qqRobot.biz.qq.handler.request;

import com.leon.project.qqRobot.biz.qq.handler.EventHandler;
import com.leon.project.qqRobot.enums.RequestType;
import com.leon.project.qqRobot.service.http.model.QQEventMsg;

@RequestHandlerRegister(RequestType.GROUP)
public class GroupRequestHandler implements EventHandler {
    @Override
    public void handle(QQEventMsg qqEventMsg) {

    }
}
