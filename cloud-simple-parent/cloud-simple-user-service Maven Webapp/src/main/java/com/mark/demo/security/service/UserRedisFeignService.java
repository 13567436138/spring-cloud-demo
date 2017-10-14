package com.mark.demo.security.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mark.demo.security.entity.User;

/*
*hxp(hxpwangyi@126.com)
*2017年10月14日
*
*/
@FeignClient(name="redisService")
@RequestMapping("/service/redis/user")
public interface UserRedisFeignService {
	@RequestMapping("/setMapField/list")
	boolean setMapFieldMenu(@RequestParam("key")String key,@RequestParam("field")String field,@RequestBody List<User> value);
}
