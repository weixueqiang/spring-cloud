package com.itmuch.cloud.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeign;
import com.itmuch.cloud.feign.UserFeignWhitFallbackClass;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {
//  @Autowired
//  private RestTemplate restTemplate;

  @Autowired
  private UserFeign userFeign;
//  @Value("${user.userServicePath}")
//  private String userServicePath;

  @Autowired
  private UserFeignWhitFallbackClass userFeignWhitFallbackClass;
  
//  @GetMapping("/movie/{id}")
//  public User findById(@PathVariable Long id) {
//    return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
//  }
  
  @GetMapping("/getUser/{id}")
  @HystrixCommand(fallbackMethod="findeById")
  public User getUser(@PathVariable Long id) {
    return userFeign.getUser(id);
  }
  
  public User findeById(Long id) {
	  User user = new User();
	  user.setAge((short)1111);
	  user.setBalance(new BigDecimal(123.23D));
	  user.setName("111111111");
	  user.setId(id);
	  user.setUsername("111111111");
	  return user;
  }
  
  @GetMapping("/findUser/{id}")
  public User findUser(@PathVariable Long id) {
    return userFeignWhitFallbackClass.findUser(id);
  }
  
}
