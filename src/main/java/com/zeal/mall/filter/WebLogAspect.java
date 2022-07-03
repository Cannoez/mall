package com.zeal.mall.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description: 打印请求和响应信息
 * @date: 2022-06-11 16:32
 */
@Aspect
@Component
public class WebLogAspect {
    //用log来记录日志
    private final Logger log= LoggerFactory.getLogger(WebLogAspect.class);

    //就是一个切点 用来区分请求和响应的点
    @Pointcut("execution(public * com.zeal.mall.controller.*.*(..))")
    public void weblog(){

    }

    //获取请求信息
    @Before("weblog()")
    public void doBefore(JoinPoint joinPoint){
        //收到请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录请求
        //打印URL
        log.info("URL:"+request.getRequestURI().toString());
       //打印请求类型
        log.info("HTTP_METHOD:"+request.getMethod());
        //打印Ip
        log.info("IP:"+request.getRemoteAddr());
        //打印类的方法
        log.info("CLASS_METHOD:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //打印参数 参数是一个数组形式
        log.info("ARGS:"+ Arrays.toString(joinPoint.getArgs()));
    }


    //获取响应信息
    @AfterReturning(returning = "res",pointcut = "weblog()")
    public void doAfterReturning(Object res) throws JsonProcessingException {
        //处理完请求返回内容 需要将res对象转换成json格式
        log.info("RESPONSE:"+new ObjectMapper().writeValueAsString(res));
    }
}
