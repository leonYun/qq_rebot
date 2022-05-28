package com.leon.project.qqRobot.biz.qq.handler.message;

import com.leon.project.qqRobot.enums.MessageType;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface MessageHandlerRegister {
    MessageType value();
}
