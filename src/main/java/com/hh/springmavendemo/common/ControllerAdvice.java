package com.hh.springmavendemo.common;

import com.hh.springmavendemo.common.exception.ProjectException;
import com.hh.springmavendemo.common.model.ResultDTO;
import com.hh.springmavendemo.common.model.ResultMap;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author YAOSHUNYU
 * @Date 2019/9/20
 * @Time 10:01
 */

@Aspect
@Component
@Slf4j
public class ControllerAdvice {

    @Pointcut("execution(public com.hh.springmavendemo.common.model.ResultDTO *..controller..*.*(..))")
    public void controllerPointCut() {
    }

    @Around("controllerPointCut()")
    public ResultDTO resultLog(ProceedingJoinPoint joinPoint) {
        Long startTimeStamp = new Date().getTime();
        Integer resultFlag = 0;
        try {
            ResultDTO resultDTO = (ResultDTO) joinPoint.proceed(joinPoint.getArgs());
            resultFlag = 0;
            return resultDTO;
        } catch (ProjectException e) {
            log.warn(e.getMessage());
            resultFlag = 1;
            return ResultMap.getCustomException(e);
        } catch (Throwable t) {
            log.error(t.getMessage());
            resultFlag = 2;
            return ResultMap.getCustomException(ExceptionEnum.UNEXPECTED_SERVER_ERRO);
        } finally {
            long interval = System.currentTimeMillis() - startTimeStamp;
            StringBuffer logMessage = new StringBuffer();
            logMessage
                    .append(joinPoint.getTarget().getClass().getSimpleName())
                    .append(".")
                    .append(joinPoint.getSignature().getName())
                    .append(":");
            switch (resultFlag) {
                case 0:
                    logMessage.append(" Success!");
                    break;
                case 1:
                    logMessage.append(" Project Exception!");
                    break;
                case 2:
                    logMessage.append(" Internal Server Error");
                    break;
            }
            logMessage.append(" Time costs: ")
                    .append(interval)
                    .append(" ms!");
            log.info(logMessage.toString());
        }
    }
}
