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
@FeignClient(name="menuRedisFeignService",url="http://localhost:8083")
@RequestMapping("/redis/common")
public interface MenuRedisFeignService {
	@RequestMapping("/setMapField/menu")
	boolean setMapFieldMenu(@RequestParam("key")String key,@RequestParam("field")String field,@RequestBody List<Menu> value);
}
