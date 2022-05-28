package com.leon.project.qqRobot.controller;

import cn.hutool.json.JSONUtil;
import com.google.common.collect.Maps;
import com.leon.project.qqRobot.biz.qq.QQMsgBiz;
import com.leon.project.qqRobot.contants.Constants;
import com.leon.project.qqRobot.service.http.model.QQEventMsg;
import com.leon.project.qqRobot.service.http.model.req.SendMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/qq")
public class QQController {

    @Resource
    private QQMsgBiz qqMsgBiz;

    @PostMapping("/")
    public void reviveMsg(@RequestBody QQEventMsg qqEventMsg) {
        if (StringUtils.equals(Constants.MetaEventType.HEART_BEAT, qqEventMsg.getMetaEventType())) {
            return ;
        }
        log.info("接收到了消息: {}", JSONUtil.toJsonStr(qqEventMsg));
        qqMsgBiz.handleMessage(qqEventMsg);
    }

    @PostMapping("/sendMsg")
    public Map sendMsg(@RequestBody SendMsg sendMsg) {
        log.info("收到发送消息的请求：{}", JSONUtil.toJsonStr(sendMsg));
        return qqMsgBiz.sendMsg(sendMsg);
    }
}
