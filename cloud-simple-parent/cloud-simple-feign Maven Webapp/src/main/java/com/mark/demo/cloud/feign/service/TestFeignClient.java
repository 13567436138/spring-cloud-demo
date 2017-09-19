package com.mark.demo.cloud.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
*hxp(hxpwangyi@126.com)
*2017年9月19日
*
*/
@FeignClient
public interface TestFeignClient {
	@RequestMapping(value = "/", method = RequestMethod.GET)
    String test();
}
