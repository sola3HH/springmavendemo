package com.hh.springmavendemo.common.exception;

import com.hh.springmavendemo.common.ExceptionEnum;
import lombok.Data;

@Data
public class ProjectException extends Exception {
    private final int code;

    public ProjectException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

    public ProjectException(String msg, int code) {
        super(msg);
        this.code = code;
    }
}
