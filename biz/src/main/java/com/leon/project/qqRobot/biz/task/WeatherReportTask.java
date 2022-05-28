package com.leon.project.qqRobot.biz.task;

import cn.hutool.json.JSONUtil;
import com.leon.project.qqRobot.biz.qq.QQOperatorBiz;
import com.leon.project.qqRobot.biz.weather.WeatherBiz;
import com.leon.project.qqRobot.model.weather.WeatherWarning;
import com.leon.project.qqRobot.service.service.model.QQUserConfig;
import com.leon.project.qqRobot.service.service.repository.QQUserConfigRepository;
import com.leon.project.qqRobot.template.BatchPageLoadTemplate;
import com.leon.project.qqRobot.utils.Safes;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

@Component
@Slf4j
public class WeatherReportTask {

    @Resource
    private QQUserConfigRepository qqUserConfigRepository;

    @Resource
    private QQOperatorBiz qqOperatorBiz;

    @Scheduled(cron = "0 30 9 * * ?")
    public void sendWeatherReport() {
        log.info("执行定时发送天气信息");
        doSendWeather(qqUserConfig -> qqOperatorBiz.sendCurrentWeatherMsg(qqUserConfig));
    }

    @Scheduled(cron = "0 10 8-22 * * ?")
//    @Scheduled(cron = "0 0/1 * * * ?")
    public void sendWeatherWarning() {
        log.info("执行定时获取灾祸数据");
        doSendWeather(qqUserConfig -> qqOperatorBiz.sendWeatherWarning(qqUserConfig));
    }

    private void doSendWeather(Consumer<QQUserConfig> consumer) {
        Pageable pageable = PageRequest.ofSize(20);
        new BatchPageLoadTemplate<Pageable, QQUserConfig>(pageable) {
            @Override
            protected List<QQUserConfig> query(Pageable page) {
                return qqUserConfigRepository.findAll(page).getContent();
            }
        }.execute().forEachRemaining(qqUserConfig -> {
            log.info("发送人：{}", JSONUtil.toJsonStr(qqUserConfig));
            if (!qqUserConfig.getEnable()) {
                return;
            }
            try {
                consumer.accept(qqUserConfig);
            } catch (Exception e) {
                log.error("执行出错", e);
            }
        });
    }
}
