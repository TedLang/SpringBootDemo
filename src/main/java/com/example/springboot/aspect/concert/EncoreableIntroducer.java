package com.example.springboot.aspect.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @Author: Yu
 * @Date: 2019-05-11
 * @Descripe:
 */
@Aspect
public class EncoreableIntroducer {
  @DeclareParents(value = "com.example.springboot.aspect.concert.Performance+",
      defaultImpl = DefaultEncoreable.class)
  public static Encoreable encoreable;
}
