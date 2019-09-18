package com.hh.springmavendemo.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public enum ExceptionEnum {

    SUCCESS(20000, "成功"),
    UNEXPECTED_SERVER_ERROs(20001, "未知的内部错误"),
    AUTHENTIFICATION_FAILED(2002,"app用户名密码错误"),
    ILLEGAL_ARGUMENT(20003, "参数不正确"),
    USER_NOTFOUND(20004,"用户不存在"),
    USER_EXISTS(20005,"用户已存在");

    private int code;
    private String message;

    public static final Map<Integer, ExceptionEnum> MY_MAP = new HashMap<>();

    static {
        for (ExceptionEnum e : values()) {
            MY_MAP.put(e.getCode(), e);
        }
    }

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ExceptionEnum getByCode(int code) {
        return MY_MAP.get(code);
    }
}
