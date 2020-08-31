package com.hh.springmavendemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hh.springmavendemo.common.ExceptionEnum;
import com.hh.springmavendemo.common.exception.ProjectException;
import com.hh.springmavendemo.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author YAOSHUNYU
 * @Date 2020/8/31
 * @Time 17:11
 */
@Slf4j
public class RestTemplateServiceImpl implements RestTemplateService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
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

    @Override
    public String getForJson(String url) throws ProjectException {
        String resultStr = "";
        try {
            log.info("Get for {}", url);
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
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


    @Override
    public String getForJson(String url, JSONObject params) throws ProjectException {
        String resultStr = "";
        try {
            log.info("Get for {} \nwith params: {}", url, params.toJSONString());
            Map map = (Map) JSONObject.parse(params.toJSONString());
            ResponseEntity responseEntity = restTemplate.getForEntity(url, String.class, map);
            JSONObject result = JSONObject.parseObject((String) responseEntity.getBody());
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
