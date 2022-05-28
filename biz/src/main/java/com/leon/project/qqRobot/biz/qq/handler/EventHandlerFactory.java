package com.leon.project.qqRobot.biz.qq.handler;

import com.leon.project.qqRobot.biz.qq.handler.message.MessageHandlerRegister;
import com.leon.project.qqRobot.biz.qq.handler.post.PostHandlerRegister;
import com.leon.project.qqRobot.biz.qq.handler.request.RequestHandlerRegister;
import com.leon.project.qqRobot.enums.MessageType;
import com.leon.project.qqRobot.enums.PostType;
import com.leon.project.qqRobot.enums.RequestType;
import com.leon.project.qqRobot.utils.Safes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class EventHandlerFactory {
    private static Map<RequestType, EventHandler> requestTypeEventHandlerMap;
    private static Map<PostType, EventHandler> postTypeEventHandlerMap;
    private static Map<MessageType, EventHandler> messageTypeEventHandlerMap;

    /**
     * 消息处理的入口
     * @param messageType
     * @return
     */
    public static EventHandler getEventHandler(MessageType messageType) {
        return messageTypeEventHandlerMap.get(messageType);
    }
    public static EventHandler getEventHandler(PostType postType) {
        return postTypeEventHandlerMap.get(postType);
    }

    public static EventHandler getEventHandler(RequestType requestType) {
        return requestTypeEventHandlerMap.get(requestType);
    }

    @Autowired
    public void setMessageTypeEventHandlerMap(List<EventHandler> eventHandlers) {
        requestTypeEventHandlerMap = Safes.of(eventHandlers).stream()
                .filter(eventHandler -> Objects.nonNull(AnnotationUtils.findAnnotation(eventHandler.getClass(), RequestHandlerRegister.class)))
                .collect(Collectors.toMap(eventHandler -> AnnotationUtils.findAnnotation(eventHandler.getClass(), RequestHandlerRegister.class).value(), Function.identity()));

        postTypeEventHandlerMap = Safes.of(eventHandlers).stream()
                .filter(eventHandler -> Objects.nonNull(AnnotationUtils.findAnnotation(eventHandler.getClass(), PostHandlerRegister.class)))
                .collect(Collectors.toMap(eventHandler -> AnnotationUtils.findAnnotation(eventHandler.getClass(), PostHandlerRegister.class).value(), Function.identity()));

        messageTypeEventHandlerMap = Safes.of(eventHandlers).stream()
                .filter(eventHandler -> Objects.nonNull(AnnotationUtils.findAnnotation(eventHandler.getClass(), MessageHandlerRegister.class)))
                .collect(Collectors.toMap(eventHandler -> AnnotationUtils.findAnnotation(eventHandler.getClass(), MessageHandlerRegister.class).value(), Function.identity()));
    }
}
