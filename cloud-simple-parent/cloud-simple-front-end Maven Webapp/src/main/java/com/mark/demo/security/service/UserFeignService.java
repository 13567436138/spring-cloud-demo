package com.mark.demo.security.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mark.demo.security.entity.Menu;
import com.mark.demo.security.entity.User;

/*
*hxp(hxpwangyi@126.com)
*2017年9月8日
*
*/
@FeignClient("userService")
@RequestMapping("/user")
public interface UserFeignService {
	@RequestMapping("/getUserByUserName")
	User getUserByUserName(String userName);
}
