package com.leon.project.qqRobot.biz.qq.handler.request;

import com.leon.project.qqRobot.biz.qq.handler.EventHandler;
import com.leon.project.qqRobot.enums.RequestType;
import com.leon.project.qqRobot.service.http.model.QQEventMsg;
import com.leon.project.qqRobot.service.service.qq.QQOperatorService;

import javax.annotation.Resource;

/**
 * 加好友消息
 */
@RequestHandlerRegister(RequestType.FRIEND)
public class FriendRequestHandler implements EventHandler {
    @Resource
    private QQOperatorService operatorService;

    @Override
    public void handle(QQEventMsg qqEventMsg) {
        operatorService.approveFriend(qqEventMsg.getFlag());
    }
}
