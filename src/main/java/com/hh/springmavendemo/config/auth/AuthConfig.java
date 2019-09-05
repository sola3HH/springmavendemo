package com.hh.springmavendemo.config.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("login.auth")
@Data
public class AuthConfig {
    AppPass[] appPasses;
}
