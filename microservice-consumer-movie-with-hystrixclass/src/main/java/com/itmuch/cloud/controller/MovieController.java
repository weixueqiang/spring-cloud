package com.itmuch.cloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeignWhitFallbackClass;

@RestController
public class MovieController {

  @Autowired
  private UserFeignWhitFallbackClass userFeignWhitFallbackClass;
  
  
  @GetMapping("/findUser/{id}")
  public User findUser(@PathVariable Long id) {
    return userFeignWhitFallbackClass.findUser(id);
  }
  
}
