package com.itmuch.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@FeignClient("microservice-provider-user")
public interface UserFeign {

	@RequestMapping(value="simple/{id}",method=RequestMethod.GET)
	User getUser(@PathVariable("id") Long id);
	
}
