package com.hh.springmavendemo.utils;

import com.alibaba.fastjson.JSONObject;
import com.hh.springmavendemo.common.ExceptionEnum;
import com.hh.springmavendemo.common.exception.ProjectException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author YAOSHUNYU
 * @Date 2020/8/31
 * @Time 11:12
 */

@Slf4j
public class RestUtil {

    @Autowired
    private RestTemplate restTemplate;

    public String postForJson(String url, JSONObject params) throws ProjectException {
        String resultStr = "";
        try {
            log.info("Post for {} \n with params: {}", url, params.toJSONString());
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> requestEntity = new HttpEntity<>(params.toJSONString(), httpHeaders);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            JSONObject result = JSONObject.parseObject(responseEntity.getBody());
            if (result == null) {
                throw new ProjectException("Response null from " + url, ExceptionEnum.UNEXPECTED_SERVER_ERRO.getCode());
            }
            resultStr = result.toJSONString();
            log.info("Get response from " + url + "\nResponse: " + resultStr);
        } catch (Exception e) {
            throw new ProjectException(e.getMessage(), ExceptionEnum.UNEXPECTED_SERVER_ERRO.getCode());
        }
        return resultStr;
    }
}
