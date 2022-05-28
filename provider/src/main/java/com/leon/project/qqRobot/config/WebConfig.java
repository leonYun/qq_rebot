package com.leon.project.qqRobot.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 将StringHttpMessageConverter设成UTF8格式
        converters.stream()
                .filter(c -> c instanceof StringHttpMessageConverter)
                .map(c -> (StringHttpMessageConverter) c)
                .forEach(c -> c.setDefaultCharset(StandardCharsets.UTF_8));

        // 将MappingJackson2HttpMessageConverter设为自己的ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setPropertyNamingStrategy( PropertyNamingStrategies.SNAKE_CASE);

        converters.stream()
                .filter(c -> c instanceof MappingJackson2HttpMessageConverter)
                .map(c -> (MappingJackson2HttpMessageConverter) c)
                .forEach(c -> c.setObjectMapper(mapper));
    }
}
