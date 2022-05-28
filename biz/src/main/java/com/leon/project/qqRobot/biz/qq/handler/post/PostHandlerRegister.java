package com.leon.project.qqRobot.biz.qq.handler.post;

import com.leon.project.qqRobot.enums.PostType;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface PostHandlerRegister {
    PostType value();
}
