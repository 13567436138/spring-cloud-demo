package com.mark.demo.security.controller;

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
@RequestMapping("/redis/common")
public class CommonRedisController {
	@RequestMapping("/setObject")
	public void setObject(String key,@RequestBody Object value, Integer cacheSeconds){
		JedisUtils.setObject(key, value, cacheSeconds);
	}
	
	
	@RequestMapping("/del")
	public void del(String key){
		JedisUtils.del(key);
	}
	
	@RequestMapping("/getObject")
	public Object getObject(String key){
		return JedisUtils.getObject(key);
	}
	
	@RequestMapping("/expire")
	public boolean expire(String key, int expireSeconds){
		return JedisUtils.expire(key, expireSeconds);
	}
	
	@RequestMapping("/getMapLen")
	public int getMapLen(String key){
		return JedisUtils.getMapLen(key);
	}
	
	@RequestMapping("/getMapFiled")
	public Object getMapFiled(String key,String field){
		return JedisUtils.getMapFiled(key, field);
	}
	
	@RequestMapping("/removeMapField")
	public boolean removeMapField(String key,String field){
		return JedisUtils.removeMapField(key, field);
	}
}