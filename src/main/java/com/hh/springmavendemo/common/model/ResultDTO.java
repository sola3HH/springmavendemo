package com.hh.springmavendemo.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hh.springmavendemo.common.ExceptionEnum;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
public class ResultDTO<T> {
    @JsonProperty("code")
    private Integer resultCode;
    @JsonProperty("msg")
    private String resultMessage;
    private T result;

    public ResultDTO() {
        this.resultCode = ExceptionEnum.SUCCESS.getCode();
        this.resultMessage = ExceptionEnum.SUCCESS.getMessage();
    }

    public ResultDTO(Integer resultCode, String resultMessage, T result) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.result = result;
    }
}
