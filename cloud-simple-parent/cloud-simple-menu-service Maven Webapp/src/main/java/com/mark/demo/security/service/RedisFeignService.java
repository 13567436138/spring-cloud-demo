package com.mark.demo.security.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/*
*hxp(hxpwangyi@126.com)
*2017年10月14日
*
*/
@FeignClient("redisFeignService")
@RequestMapping("/redis")
public interface RedisFeignService {
	@RequestMapping("/setObject")
	void setObject(String key, Object value, Integer cacheSeconds);
	@RequestMapping("/del")
	void del(String key);
	@RequestMapping("/getObject")
	Object getObject(String key);
	@RequestMapping("/expire")
	boolean expire(String key, int expireSeconds);
	@RequestMapping("/getMapLen")
	int getMapLen(String key);
	@RequestMapping("/setMapField")
	boolean setMapField(String key,String field,Object value);
	@RequestMapping("/getMapFiled")
	Object getMapFiled(String key,String field);
	@RequestMapping("/removeMapField")
	boolean removeMapField(String key,String field);
}
