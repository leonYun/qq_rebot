package com.leon.project.qqRobot.utils;

import cn.hutool.json.JSONUtil;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;

public class PropertyUtil {


    public static <T> T getPropertyAsClazz(Object bean, String name, Class<T> tClass) {
        Object property = getProperty(bean, name);
        return JSONUtil.toBean(JSONUtil.toJsonStr(property), tClass);
    }

    public static String getPropertyAsString(Object bean, String name) {
        Object property = getProperty(bean, name);
        return String.valueOf(property);
    }

    public static <T> List<T> getPropertyAsList(Object bean, String name, Class<T> itemClazz) {
        Object property = getProperty(bean, name);
        return JSONUtil.toList(JSONUtil.toJsonStr(property), itemClazz);
    }


    private static Object getProperty(Object bean, String name) {
        Object property;
        try {
            property = PropertyUtils.getProperty(bean, name);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("解析过程中发生了错误");
        }
        return property;
    }
}
