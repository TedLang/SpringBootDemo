package com.example.springboot.controller;

import com.example.springboot.entity.ConfigBean;
import com.example.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Yu
 * @Date: 2019-02-10
 * @Descripe:
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class LucyController {

  @Autowired
  ConfigBean configBean;

  @RequestMapping(value = "/lucy/")
  public String lucy() {
    return configBean.getGreeting() + ">>> " + configBean.getName();
  }

  @Autowired
  User user;

  @RequestMapping(value="/user")
  public String user() {
    return user.getName() + " : " + user.getAge();
  }
}
