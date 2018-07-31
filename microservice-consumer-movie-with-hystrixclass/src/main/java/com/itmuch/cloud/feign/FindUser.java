package com.itmuch.cloud.feign;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.itmuch.cloud.entity.User;
@Component
public class FindUser implements UserFeignWhitFallbackClass {

	@Override
	public User findUser(Long id) {
		User user = new User();
		user.setAge((short) 1111);
		user.setBalance(new BigDecimal(123.23D));
		user.setName("--------");
		user.setId(id);
		user.setUsername("111111111");
		return user;
	}

}
