package com.hh.springmavendemo.service;

public interface AuthService {
    Boolean isValidPass(String appId, String appSecret);
}
