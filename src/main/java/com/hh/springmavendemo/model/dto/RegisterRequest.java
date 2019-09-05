package com.hh.springmavendemo.model.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String appId;
    private String appSecret;
    private String name;
    private String password;
}
