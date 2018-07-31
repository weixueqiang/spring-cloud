package com.itmuch.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@FeignClient(name="microservice-provider-user",fallback=FindUser.class)
public interface UserFeignWhitFallbackClass {

	@RequestMapping(value="simple/{id}",method=RequestMethod.GET)
	User findUser(@PathVariable("id") Long id);
	
}
