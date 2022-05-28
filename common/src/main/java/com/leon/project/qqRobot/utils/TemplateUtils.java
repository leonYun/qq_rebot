package com.leon.project.qqRobot.utils;

import cn.hutool.core.map.MapUtil;
import com.leon.project.qqRobot.contants.Constants;
import com.leon.project.qqRobot.enums.CqCode;
import com.leon.project.qqRobot.model.weather.DailyIndices;
import com.leon.project.qqRobot.model.weather.WeatherWarning;
import com.leon.project.qqRobot.model.weather.report.WeatherReport;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.core.io.ClassPathResource;
import org.stringtemplate.v4.ST;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TemplateUtils {
    private static final String WEATHER_REPORT_TEMPLATE;
    private static final String DAILY_INDICES_TEMPLATE;
    private static final String WEATHER_WARNING_TEMPLATE;
    static {
        WEATHER_REPORT_TEMPLATE = loadTemplate("/stg/weather_report.stg");
        DAILY_INDICES_TEMPLATE = loadTemplate("/stg/daily_indices.stg");
        WEATHER_WARNING_TEMPLATE = loadTemplate("/stg/weather_warning.stg");
    }

    private static String loadTemplate(String path) {
        ClassPathResource classPathResource = new ClassPathResource(path);
        try {
            List<String> strings = IOUtils.readLines(classPathResource.getInputStream(), StandardCharsets.UTF_8);
            return String.join("\n", Safes.of(strings));
        } catch (IOException e) {
            throw new RuntimeException("读取文件\"/stg/weather_report.stg\"失败", e);
        }
    }

    @SneakyThrows
    public static String getWeatherReport(WeatherReport weatherReport) {
        ST st = new ST(WEATHER_REPORT_TEMPLATE);
        Map<String, String> describe = BeanUtils.describe(weatherReport);
        describe.forEach(st::add);
        return st.render();
    }

    public static String getDailyIndices(List<DailyIndices> dailyIndices) {
        return Safes.of(dailyIndices).stream()
                .map(indices -> {
                    ST st = new ST(DAILY_INDICES_TEMPLATE);
                    st.add("name", indices.getName());
                    st.add("text", indices.getText());
                    return st.render();
                }).collect(Collectors.joining("\n"));
    }

    @SneakyThrows
    public static String getWeatherWarning(WeatherWarning weatherWarning) {
        ST st = new ST(WEATHER_WARNING_TEMPLATE);
        Map<String, String> describe = BeanUtils.describe(weatherWarning);
        describe.forEach(st::add);
        return st.render();
    }

    public static String getTimeQuantum() {
        DateTime now = DateTime.now();
        int hourOfDay = now.getHourOfDay();
        if (hourOfDay < 6) {
            return "凌晨";
        }
        if (hourOfDay < 11) {
            return "早上";
        }
        if (hourOfDay < 14) {
            return "中午";
        }
        if (hourOfDay < 19) {
            return "下午";
        }
        return "晚上";
    }

    public static String getIcon(String weather) {
        if (StringUtils.contains(weather, "多云")) {
            return CqCode.FACE.genQcCodeString(MapUtil.builder(Constants.CqCode.Face.ID, "91").build());
        }
        if (StringUtils.contains(weather, "雨")) {
            return CqCode.FACE.genQcCodeString(MapUtil.builder(Constants.CqCode.Face.ID, "90").build());
        }
        if (StringUtils.contains(weather, "晴")) {
            return CqCode.FACE.genQcCodeString(MapUtil.builder(Constants.CqCode.Face.ID, "74").build());
        }
        return StringUtils.EMPTY;
    }
}
