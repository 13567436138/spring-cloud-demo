package com.mark.demo.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mark.demo.security.utils.JedisUtils;

/*
*hxp(hxpwangyi@126.com)
*2017年10月14日
*
*/
@RestController
@RequestMapping("/redis")
public class RedisController {
	@RequestMapping("/setObject")
	public void setObject(String key, Object value, Integer cacheSeconds){
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
	
	@RequestMapping("/setMapField")
	public boolean setMapField(String key,String field,Object value){
		return JedisUtils.setMapField(key, field, value);
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
