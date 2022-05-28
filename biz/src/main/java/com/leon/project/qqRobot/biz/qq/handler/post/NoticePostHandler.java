package com.leon.project.qqRobot.biz.qq.handler.post;

import com.leon.project.qqRobot.biz.qq.handler.EventHandler;
import com.leon.project.qqRobot.enums.PostType;
import com.leon.project.qqRobot.service.http.model.QQEventMsg;

@PostHandlerRegister(PostType.NOTICE)
public class NoticePostHandler implements EventHandler {
    @Override
    public void handle(QQEventMsg qqEventMsg) {

    }
}
