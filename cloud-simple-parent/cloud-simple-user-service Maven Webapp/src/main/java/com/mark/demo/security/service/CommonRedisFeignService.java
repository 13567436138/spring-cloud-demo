package com.mark.demo.security.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mark.demo.security.entity.Menu;

/*
*hxp(hxpwangyi@126.com)
*2017年10月14日
*
*/
@FeignClient(name="commonRedisFeignService",url="http://localhost:8083")
@RequestMapping("/redis/common")
public interface CommonRedisFeignService {
	@RequestMapping("/setObject")
	void setObject(@RequestParam("key")String key,@RequestBody Object value,@RequestParam("cacheSeconds") Integer cacheSeconds);
	@RequestMapping("/del")
	void del(String key);
	@RequestMapping("/getObject")
	Object getObject(String key);
	@RequestMapping("/expire")
	boolean expire(@RequestParam("key")String key,@RequestParam("expireSeconds") int expireSeconds);
	@RequestMapping("/getMapLen")
	int getMapLen(String key);
	
	@RequestMapping("/getMapFiled")
	Object getMapFiled(@RequestParam("key")String key,@RequestParam("field")String field);
	@RequestMapping("/removeMapField")
	boolean removeMapField(@RequestParam("key")String key,@RequestParam("field")String field);
}
