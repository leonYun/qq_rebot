package com.leon.project.qqRobot.biz.qq.handler.message;

import cn.hutool.json.JSONUtil;
import com.leon.project.qqRobot.biz.qq.QQOperatorBiz;
import com.leon.project.qqRobot.biz.qq.handler.EventHandler;
import com.leon.project.qqRobot.biz.weather.WeatherBiz;
import com.leon.project.qqRobot.enums.MessageType;
import com.leon.project.qqRobot.service.http.client.RunHttpClient;
import com.leon.project.qqRobot.service.http.client.appService.CommonUtilHttpClient;
import com.leon.project.qqRobot.service.http.contanst.VariableConstant;
import com.leon.project.qqRobot.service.http.model.QQEventMsg;
import com.leon.project.qqRobot.service.service.model.QQUserConfig;
import com.leon.project.qqRobot.service.service.qq.QQOperatorService;
import com.leon.project.qqRobot.service.service.repository.QQUserConfigRepository;
import com.leon.project.qqRobot.utils.PropertyUtil;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

@MessageHandlerRegister(MessageType.PRIVATE)
public class PrivateMessageHandler implements EventHandler {
    @Resource
    private QQOperatorService qqOperatorService;

    @Resource
    private CommonUtilHttpClient commonUtilHttpClient;

    @Resource
    private QQUserConfigRepository qqUserConfigRepository;

    @Resource
    private QQOperatorBiz qqOperatorBiz;

    @Resource
    private RunHttpClient runHttpClient;

    @Override
    public void handle(QQEventMsg qqEventMsg) {
        if (StringUtils.equals(qqEventMsg.getRawMessage(), "天气")) {
            QQUserConfig byQq = qqUserConfigRepository.findByQq(qqEventMsg.getUserId());
            if (Objects.nonNull(byQq)) {
                qqOperatorBiz.sendCurrentWeatherMsg(byQq);
                return;
            }
        }
        if (StringUtils.equals(qqEventMsg.getRawMessage(), "预警")) {
            QQUserConfig byQq = qqUserConfigRepository.findByQq(qqEventMsg.getUserId());
            if (Objects.nonNull(byQq)) {
                qqOperatorBiz.sendWeatherWarning(byQq);
                return;
            }
        }
        if (StringUtils.equals(qqEventMsg.getRawMessage(), "运行")) {
            qqOperatorService.sendPrivateMsg(JSONUtil.toJsonStr(runHttpClient.toRun()), qqEventMsg.getUserId());
            return;
        }

        if (StringUtils.equals(qqEventMsg.getRawMessage(), "统计")) {
            qqOperatorService.sendPrivateMsg(JSONUtil.toJsonStr(runHttpClient.count()), qqEventMsg.getUserId());
            return;
        }

        Map replay = commonUtilHttpClient.getReplay(qqEventMsg.getRawMessage());
        String replayMsg = PropertyUtil.getPropertyAsString(replay, VariableConstant.ResponseParser.CONTENT);
        qqOperatorService.sendPrivateMsg(replayMsg, qqEventMsg.getUserId());
    }
}
