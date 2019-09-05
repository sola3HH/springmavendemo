package com.hh.springmavendemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("swagger")
@Data
public class SwaggerProperties {
    private boolean enable;

    private String basePackage;

    private String title;

    private String description;

    private String version;
}
