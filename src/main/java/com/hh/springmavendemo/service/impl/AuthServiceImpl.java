package com.hh.springmavendemo.service.impl;

import com.hh.springmavendemo.config.auth.AppPass;
import com.hh.springmavendemo.config.auth.AuthConfig;
import com.hh.springmavendemo.service.AuthService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService, InitializingBean {
    private final AuthConfig authConfig;

    private Map<String, String> appPassMap;

    @Override
    public void afterPropertiesSet() throws Exception {
        appPassMap = new HashMap<>();
        for (AppPass appPass : authConfig.getAppPasses()) {
            appPassMap.put(appPass.getAppId(), appPass.getAppSecret());
        }
    }

    @Autowired
    public AuthServiceImpl(AuthConfig authConfig) {
        this.authConfig = authConfig;
    }

    @Override
    public Boolean isValidPass(String appId, String appSecret) {
        return appPassMap.get(appId).equals(appSecret);
    }
}
