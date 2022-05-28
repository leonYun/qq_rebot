package com.leon.project.qqRobot.biz.qq.handler.request;

import com.leon.project.qqRobot.enums.RequestType;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface RequestHandlerRegister {
    RequestType value();
}
