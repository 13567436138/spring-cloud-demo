package com.mark.demo.security.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
*hxp(hxpwangyi@126.com)
*2017年10月14日
*
*/
@FeignClient(name="redis",url="http://localhost:9999/service/redis/common")
@RequestMapping("/service/redis/common")
public interface CommonRedisFeignService {
	@RequestMapping("/setObject")
	void setObject(@RequestParam("key")String key,@RequestBody Object value,@RequestParam("cacheSeconds") Integer cacheSeconds);
	@RequestMapping("/setString")
	void setString(@RequestParam("key")String key,@RequestParam("value") String value,@RequestParam("cacheSeconds") Integer cacheSeconds);
	@RequestMapping("/del")
	void del(@RequestParam("key")String key);
	@RequestMapping("/getObject")
	Object getObject(@RequestParam("key")String key);
	@RequestMapping("/getString")
	String getString(@RequestParam("key")String key);
	@RequestMapping("/expire")
	boolean expire(@RequestParam("key")String key,@RequestParam("expireSeconds") int expireSeconds);
	@RequestMapping("/getMapLen")
	int getMapLen(@RequestParam("key")String key);
	
	@RequestMapping("/getMapFiled")
	Object getMapFiled(@RequestParam("key")String key,@RequestParam("field")String field);
	@RequestMapping("/removeMapField")
	boolean removeMapField(@RequestParam("key")String key,@RequestParam("field")String field);
}
