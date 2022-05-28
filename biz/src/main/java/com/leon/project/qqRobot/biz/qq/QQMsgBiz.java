package com.leon.project.qqRobot.biz.qq;

import cn.hutool.core.map.MapUtil;
import com.leon.project.qqRobot.biz.qq.handler.EventHandler;
import com.leon.project.qqRobot.biz.qq.handler.EventHandlerFactory;
import com.leon.project.qqRobot.enums.MessageType;
import com.leon.project.qqRobot.service.http.client.appService.CommonUtilHttpClient;
import com.leon.project.qqRobot.service.http.contanst.VariableConstant;
import com.leon.project.qqRobot.service.http.model.QQEventMsg;
import com.leon.project.qqRobot.service.http.model.req.SendMsg;
import com.leon.project.qqRobot.service.http.client.QQHttpClient;
import com.leon.project.qqRobot.service.service.qq.QQOperatorService;
import com.leon.project.qqRobot.utils.PropertyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Service
public class QQMsgBiz {

    @Resource
    private QQOperatorService qqOperatorService;

    public void handleMessage(QQEventMsg qqEventMsg) {
        EventHandler eventHandler = EventHandlerFactory.getEventHandler(MessageType.getType(qqEventMsg.getMessageType()));
        if (Objects.nonNull(eventHandler)) {
            eventHandler.handle(qqEventMsg);
        }
    }

    public Map sendMsg(SendMsg sendMsg) {
        MessageType type = MessageType.getType(sendMsg.getMessageType());

        if (type == MessageType.PRIVATE) {
            return qqOperatorService.sendPrivateMsg(sendMsg);
        }
        if (type == MessageType.GROUP) {
            return qqOperatorService.sendGroupMsg(sendMsg);
        }
        return Collections.EMPTY_MAP;
    }
}
