package com.itmuch.cloud.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;

@RestController
public class UserController {


  @GetMapping("/simple/{id}")
  public User findById(@PathVariable Long id) {
	  User user = new User();
	  user.setAge((short)13);
	  user.setBalance(new BigDecimal(123.23D));
	  user.setName("adimin");
	  user.setId(id);
	  user.setUsername("zhangsan");
	  System.out.println(id+"----------->>>>>>>>\n"+user.getUsername()+":"+user.getAge());
    return user;
  }


  @PostMapping("/user")
  public User postUser(@RequestBody User user) {
    return user;
  }

  // 该请求不会成功
  @GetMapping("/get-user")
  public User getUser(User user) {
    return user;
  }

//  @GetMapping("list-all")
//  public List<User> listAll() {
//    ArrayList<User> list = Lists.newArrayList();
//    User user = new User(1L, "zhangsan");
//    User user2 = new User(2L, "zhangsan");
//    User user3 = new User(3L, "zhangsan");
//    list.add(user);
//    list.add(user2);
//    list.add(user3);
//    return list;
//
//  }
}
