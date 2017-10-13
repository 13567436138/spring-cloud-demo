package com.mark.demo.cloud.feign.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mark.demo.security.entity.Menu;

/*
*hxp(hxpwangyi@126.com)
*2017年9月19日
*
*/
@FeignClient(name="test")
public interface TestFeignClient {
	@RequestMapping(value = "/menu/getMenuTopLever", method = RequestMethod.GET)
	List<Menu> getMenuTopLever();
}
