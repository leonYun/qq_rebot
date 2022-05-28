package com.leon.project.qqRobot.biz.qq.handler.message;

import com.leon.project.qqRobot.biz.qq.handler.EventHandler;
import com.leon.project.qqRobot.biz.qq.handler.EventHandlerFactory;
import com.leon.project.qqRobot.enums.MessageType;
import com.leon.project.qqRobot.enums.PostType;
import com.leon.project.qqRobot.service.http.model.QQEventMsg;

import java.util.Objects;

@MessageHandlerRegister(MessageType.UNKNOWN)
public class UnknownMessageHandler implements EventHandler {
    @Override
    public void handle(QQEventMsg qqEventMsg) {
        EventHandler eventHandler = EventHandlerFactory.getEventHandler(PostType.getType(qqEventMsg.getPostType()));
        if (Objects.nonNull(eventHandler)) {
            eventHandler.handle(qqEventMsg);
        }
    }
}
