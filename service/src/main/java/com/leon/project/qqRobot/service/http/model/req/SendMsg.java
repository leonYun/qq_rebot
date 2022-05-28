package com.leon.project.qqRobot.service.http.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendMsg {
    /**
     * 对方qq
     */
    private String userId;

    /**
     * 群号
     */
    private String groupId;

    /**
     * 消息
     */
    private String message;

    /**
     * 是否作为纯文本发送
     */
    private Boolean autoEscape;

    /**
     * 发送消息类型
     */
    private String messageType;
}
