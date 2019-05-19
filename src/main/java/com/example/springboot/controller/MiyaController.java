package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Yu
 * @Date: 2019-02-10
 * @Descripe:
 */
@RestController
public class MiyaController {

  @Value("${my.name}")
  private String name;

  @Value("${my.age}")
  private int age;

  @RequestMapping(value = "/miya/")
  public String miya() {
    return name + " : " + age;
  }
}
