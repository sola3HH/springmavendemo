package com.hh.springmavendemo.service;

import com.alibaba.fastjson.JSONObject;
import com.hh.springmavendemo.common.exception.ProjectException;

/**
 * @author YAOSHUNYU
 * @Date 2020/8/31
 * @Time 17:10
 */


public interface RestTemplateService {
    public String postForJson(String url, JSONObject params) throws ProjectException;

    public String getForJson(String url) throws ProjectException;

    public String getForJson(String url, JSONObject params) throws ProjectException;
}
