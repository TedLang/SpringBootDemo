package com.example.springboot.utils;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Author: Yu
 * @Date: 2019-05-11
 * @Descripe:
 */
@Aspect
@Component
public class WebLogAspect {

  @Pointcut("execution (public * com.example.springboot.controller..*.* (..))")
  public void webLog() {}

  @Before(("webLog()"))
  public void doBefore(JoinPoint joinPoint) throws Throwable {
    // 接收到请求，记录请求内容
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    // 记录相关请求内容
    System.out.println("URL : " + request.getRequestURL().toString());
    System.out.println("HTTP_METHOD : " +request.getMethod());
    System.out.println("IP : " + request.getRemoteAddr());
    System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName());
    System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
  }

  @AfterReturning(returning = "ret", pointcut = "webLog()")
  public void doAfterReturning(Object ret) throws Throwable {
    // 处理完毕，返回内容
    System.out.println("RESPONSE : " + ret);
  }
}
