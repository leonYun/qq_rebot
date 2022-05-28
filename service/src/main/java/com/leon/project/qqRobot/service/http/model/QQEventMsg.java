package com.leon.project.qqRobot.service.http.model;

import lombok.Data;

@Data
public class QQEventMsg {
    /**
     * 事件发生的时间戳
     */
    private Long time;
    /**
     * 收到时间的机器人qq号
     */
    private String selfId;
    /**
     * 上报类型
     */
    private String postType;
    /**
     * 消息类型
     */
    private String messageType;

    /**
     * 通知类型
     */
    private String noticeType;
    /**
     * 消息子类型
     */
    private String subType;

    private String interval;

    private String metaEventType;

    private Object status;

    /**
     * 临时会话来源
     */
    private Integer tempSource;

    /**
     * 消息Id
     */
    private String messageId;

    /**
     * 发送者QQ号
     */
    private String userId;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 原始消息内容
     */
    private String rawMessage;

    /**
     * 字体
     */
    private Integer font;

    /**
     * 发送人信息
     */
    private Sender sender;

    /**
     * 群号
     */
    private String groupId;

    /**
     * 匿名用户信息
     */
    private Anonymous anonymous;

    /**
     * 文件信息
     */
    private Object file;

    /**
     * 操作者qq号
     */
    private String operatorId;

    /**
     * 禁言时间 单位s
     */
    private Long duration;

    /**
     * 被戳用户qq
     */
    private String targetId;

    /**
     * 荣誉类型
     * talkative:龙王 performer:群聊之火 emotion:快乐源泉
     */
    private String honorType;

    /**
     * 新名片
     */
    private String cardNew;

    /**
     * 旧名片
     */
    private String cardOld;

    /**
     * 加好友请求
     */
    private String requestType;

    /**
     * 验证信息
     */
    private String commit;

    /**
     * 消息发送人id
     */
    private String senderId;

    private String messageSeq;

    private String flag;

    private String comment;
}
