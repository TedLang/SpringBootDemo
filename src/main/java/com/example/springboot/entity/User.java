package com.example.springboot.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: Yu
 * @Date: 2019-02-10
 * @Descripe:
 */
@Configuration
@PropertySource(value="classpath:config.properties")
@ConfigurationProperties(prefix="com.example")
public class User {

  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
