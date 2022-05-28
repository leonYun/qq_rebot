package com.leon.project.qqRobot.biz.qq.handler.post;

import com.leon.project.qqRobot.biz.qq.handler.EventHandler;
import com.leon.project.qqRobot.biz.qq.handler.EventHandlerFactory;
import com.leon.project.qqRobot.enums.PostType;
import com.leon.project.qqRobot.enums.RequestType;
import com.leon.project.qqRobot.service.http.model.QQEventMsg;

import java.util.Objects;

/**
 * 添加通知
 */
@PostHandlerRegister(PostType.REQUEST)
public class RequestPostHandler implements EventHandler {
    @Override
    public void handle(QQEventMsg qqEventMsg) {
        EventHandler eventHandler = EventHandlerFactory.getEventHandler(RequestType.getType(qqEventMsg.getRequestType()));
        if (Objects.nonNull(eventHandler)) {
            eventHandler.handle(qqEventMsg);
        }
    }
}
