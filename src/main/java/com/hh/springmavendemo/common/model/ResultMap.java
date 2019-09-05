package com.hh.springmavendemo.common.model;

import com.hh.springmavendemo.common.ExceptionEnum;

public class ResultMap {
    private ResultMap(){}

    public static ResultDTO successMsg() {
        ResultDTO dto = new ResultDTO<>();
        dto.setResultCode(ExceptionEnum.SUCCESS.getCode());
        dto.setResultMessage(ExceptionEnum.SUCCESS.getMessage());
        return dto;
    }

    public static <T> ResultDTO successWithObject(T obj){
        ResultDTO dto = new ResultDTO<T>();
        dto.setResultCode(ExceptionEnum.SUCCESS.getCode());
        dto.setResultMessage(ExceptionEnum.SUCCESS.getMessage());
        dto.setResult(obj);
        return dto;
    }
}
