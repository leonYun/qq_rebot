package com.leon.project.qqRobot.enums;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public enum RequestType {
    FRIEND("friend", "加好友请求"),
    GROUP("group", "加群请求"),
    UNKNOWN("unknown", "未知");
    ;

    private final String value;
    private final String desc;

    private static Map<String, RequestType> valueMap;

    static {
        valueMap = Arrays.stream(RequestType.values())
                .collect(Collectors.toMap(RequestType::value, Function.identity()));
    }

    RequestType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String value() {
        return value;
    }

    public static RequestType getType(String value) {
        RequestType requestType = valueMap.get(value);
        if (Objects.isNull(requestType)) {
            log.error("获取RequestType失败, value: {}",value);
            return UNKNOWN;
        }
        return requestType;
    }
}
