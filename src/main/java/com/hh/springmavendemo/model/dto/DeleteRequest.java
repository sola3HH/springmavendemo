package com.hh.springmavendemo.model.dto;

import lombok.Data;

@Data
public class DeleteRequest {
    private String appId;
    private String appSecret;
    private Integer id;
}
