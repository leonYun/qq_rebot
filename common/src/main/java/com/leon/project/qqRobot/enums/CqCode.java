package com.leon.project.qqRobot.enums;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.Map;
import java.util.stream.Collectors;

public enum CqCode {
    FACE("face"),
    RECORD("record"),
    AT("at"),
    SHARE("share"),
    MUSIC("music"),
    FLASH("flash"),
    SHOW("show"),
    RELAY("reply"),
    XML("xml"),
    JSON("json"),
    CARD_IMG("cardimage"),
    TTS("tts")
    ;

    private String type;
    CqCode(String type) {
        this.type = type;
    }

    public String genQcCodeString(Map<String, String> config) {
        if (MapUtils.isEmpty(config)) {
            return StringUtils.EMPTY;
        }
        String configStr = config.entrySet().stream()
                .map(entry -> StringUtils.join(entry.getKey(), "=", entry.getValue()))
                .collect(Collectors.joining(","));
        return StringUtils.join("[CQ:", getType(), ",", configStr, "]");
    }

    public String getType() {
        return type;
    }
}
