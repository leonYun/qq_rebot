package com.leon.project.qqRobot.utils;

import com.leon.project.qqRobot.contants.CommonConstant;
import com.leon.project.qqRobot.contants.Constants;
import org.joda.time.DateTime;

public class DateUtil {
    public static String parseToStandTimeStr(String str) {
        return DateTime.parse(str).toString(CommonConstant.DATE_TIME_FORMATTER_PATTERN);
    }
}
