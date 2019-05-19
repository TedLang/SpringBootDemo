package com.example.springboot.aspect.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: Yu
 * @Date: 2019-05-11
 * @Descripe:
 */
@Aspect
public class Audience {

  @Pointcut("execution (public * com.example.springboot.aspect.concert.Performance.perform(..))")
  public void performance(){}

  @Before("performance()")
  public void silenceCellPhones() {
    System.out.println("Silencing cell phones. ");
  }

  @Before("performance()")
  public void taskSeats() {
    System.out.println("Taking seats. ");
  }

  @AfterReturning("performance()")
  public void applause() {
    System.out.println("Clap Clap Clap !!!");
  }

  @AfterThrowing("execution (public * com.example.springboot.aspect.concert.Performance.perform(..))")
  public void demandRefunt() {
    System.out.println("Demand a refund.");
  }

  @Around("performance()")
  public void watchPerformance(ProceedingJoinPoint joinPoint) {
    try {
      System.out.println("Silencing cell phones");
      System.out.println("Taking seats");
      joinPoint.proceed();
      System.out.println("Clap, Clap, Clap");
    } catch (Throwable e) {
      System.out.println("Demanding a refund");
    }
  }
}
