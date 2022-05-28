package com.leon.project.qqRobot.enums;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public enum PostType {
    MESSAGE("message", "消息"),
    NOTICE("notice", "通知"),
    REQUEST("request", "请求")
    ;

    private final String value;
    private final String desc;

    private static Map<String, PostType> valueMap;

    static {
        valueMap = Arrays.stream(PostType.values())
                .collect(Collectors.toMap(PostType::value, Function.identity()));
    }

    PostType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String value() {
        return value;
    }

    public static PostType getType(String value) {
        PostType postType = valueMap.get(value);
        if (Objects.isNull(postType)) {
            log.error("获取PostType失败, value: {}",value);
        }
        return postType;
    }
}
