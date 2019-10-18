//package com.hh.springmavendemo.config;
//
//import com.hh.springmavendemo.common.exception.ProjectException;
//import com.hh.springmavendemo.common.model.ResultDTO;
//import com.hh.springmavendemo.common.model.ResultMap;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * @author YAOSHUNYU
// * @Date 2019/10/18
// * @Time 14:35
// */
//
//@ControllerAdvice
//@Slf4j
//public class BusinessControllerAdvice {
//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public ResultDTO exceptionHandler(Exception e){
//        log.error("Exception occur: " + e.getMessage());
//        return ResultMap.getCustomException(e);
//    }
//}
