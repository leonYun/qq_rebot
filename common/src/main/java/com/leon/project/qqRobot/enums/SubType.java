package com.leon.project.qqRobot.enums;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public enum SubType {
    /**
     * 私聊
     */
    FRIEND("friend", "好友"),
    GROUP("group", "临时会话"),
    GROUP_SELF("group_self", "群中自身消息"),
    OTHER("other", "其他"),

    /**
     * 群聊
     */
    NORMAL("normal", "正常"),
    ANONYMOUS("anonymous", "匿名"),
    NOTICE("notice", "系统提示")
    ;

    private final String value;
    private final String desc;

    private static Map<String, SubType> valueMap;

    static {
        valueMap = Arrays.stream(SubType.values())
                .collect(Collectors.toMap(SubType::value, Function.identity()));
    }

    SubType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String value() {
        return value;
    }

    public static SubType getType(String value) {
        SubType subType = valueMap.get(value);
        if (Objects.isNull(subType)) {
            log.error("获取SubType失败, value: {}",value);
        }
        return subType;
    }
}
