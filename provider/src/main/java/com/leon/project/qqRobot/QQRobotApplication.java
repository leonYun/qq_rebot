package com.leon.project.qqRobot;

import com.dtflys.forest.Forest;
import com.dtflys.forest.converter.json.ForestJacksonConverter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class QQRobotApplication {
    public static void main(String[] args) {
        configForest();
        SpringApplication.run(QQRobotApplication.class, args);
    }

    private static void configForest() {
        ForestJacksonConverter forestJacksonConverter = new ForestJacksonConverter();
        com.fasterxml.jackson.databind.ObjectMapper mapper = forestJacksonConverter.getMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Forest.config().setJsonConverter(forestJacksonConverter);
    }
}
