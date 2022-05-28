package com.leon.project.qqRobot.service.http.interceptor;

import cn.hutool.json.JSONUtil;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogInterceptor<T> implements Interceptor<T> {
    @Override
    public void afterExecute(ForestRequest request, ForestResponse response) {
        log.info(" {} request [url: {}, param: {}, body: {}] response: {}", request.getType().getName(), request.getUrl(),
                JSONUtil.toJsonStr(request.getArguments()), JSONUtil.toJsonStr(request.getBody())
                , response.getContent());
    }
}
