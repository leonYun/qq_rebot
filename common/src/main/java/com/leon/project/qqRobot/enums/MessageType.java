package com.leon.project.qqRobot.enums;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public enum MessageType {
    PRIVATE("private", "私聊"),
    GROUP("group", "群聊"),
    UNKNOWN("unknown", "未知");
    ;

    private final String value;
    private final String desc;

    private static Map<String, MessageType> valueMap;

    static {
        valueMap = Arrays.stream(MessageType.values())
                .collect(Collectors.toMap(MessageType::value, Function.identity()));
    }

    MessageType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String value() {
        return value;
    }

    public static MessageType getType(String value) {
        MessageType messageType = valueMap.get(value);
        if (Objects.isNull(messageType)) {
            return UNKNOWN;
        }
        return messageType;
    }
}
