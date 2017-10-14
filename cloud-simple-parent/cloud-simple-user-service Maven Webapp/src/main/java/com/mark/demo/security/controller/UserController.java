package com.mark.demo.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mark.demo.security.entity.User;
import com.mark.demo.security.service.UserService;

/*
*hxp(hxpwangyi@126.com)
*2017年10月14日
*
*/
@RestController
@RequestMapping("/service/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/getUserByUserName")
	public User getUserByUserName(String userName){
		return userService.getUserByUserName(userName);
	}
}
