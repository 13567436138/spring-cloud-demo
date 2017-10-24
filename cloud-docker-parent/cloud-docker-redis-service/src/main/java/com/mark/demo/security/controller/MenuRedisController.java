package com.mark.demo.security.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mark.demo.security.entity.Menu;
import com.mark.demo.security.utils.JedisUtils;

/*
*hxp(hxpwangyi@126.com)
*2017年10月14日
*
*/
@RestController
@RequestMapping("/service/redis/menu")
public class MenuRedisController {
	
	
	
	@RequestMapping("/setMapField/list")
	public boolean setMapField(String key,String field,@RequestBody ArrayList<Menu> value){
		return JedisUtils.setMapField(key, field, value);
	}
	
	
}
