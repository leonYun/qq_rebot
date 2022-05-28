package com.leon.project.qqRobot.service.service.qq;

import com.leon.project.qqRobot.enums.MessageType;
import com.leon.project.qqRobot.service.http.client.QQHttpClient;
import com.leon.project.qqRobot.service.http.contanst.VariableConstant;
import com.leon.project.qqRobot.service.http.model.QQUserInfo;
import com.leon.project.qqRobot.service.http.model.req.SendMsg;
import com.leon.project.qqRobot.utils.PropertyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class QQOperatorService {
    @Resource
    private QQHttpClient qqHttpClient;

    public Map sendPrivateMsg(String msg, String receiverQQ) {
        return qqHttpClient.sendPrivateMsg(SendMsg.builder()
                .message(msg)
                .userId(receiverQQ)
                .messageType(MessageType.PRIVATE.value())
                .build());
    }

    public Map sendPrivateMsg(SendMsg sendMsg) {
        return qqHttpClient.sendPrivateMsg(sendMsg);
    }

    public Map sendGroupMsg(SendMsg sendMsg) {
        return qqHttpClient.sendGroupMsg(sendMsg);
    }

    public QQUserInfo getQQInfo(String qq) {
        Map qqInfo = qqHttpClient.getQQInfo(qq);
        return PropertyUtil.getPropertyAsClazz(qqInfo, VariableConstant.ResponseParser.DATA, QQUserInfo.class);
    }

    public void approveFriend(String flag) {
        approveFriend(flag, Boolean.TRUE);
    }

    public void approveFriend(String flag, Boolean approve) {
        qqHttpClient.approveFriendRequest(flag, approve);
    }
}
