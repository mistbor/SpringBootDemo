package com.miaoying.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ${MiaoYing} on 2017/7/8.
 */
@Aspect
@Component
public class HttpAspect {

    private final static org.slf4j.Logger logger= org.slf4j.LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.miaoying.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURI());

        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getDeclaringType());

        //参数
        logger.info("args={}",joinPoint.getArgs());

    }

    @After("log()")
    public void logAfter(){
        logger.info("222222222222222222222222");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
       // logger.info("response={}",object.toString());
    }


























}
