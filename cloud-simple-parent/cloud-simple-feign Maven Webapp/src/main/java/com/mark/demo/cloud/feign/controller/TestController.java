package com.mark.demo.cloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mark.demo.cloud.feign.service.TestFeignClient;

/*
*hxp(hxpwangyi@126.com)
*2017年9月19日
*
*/
@RestController
public class TestController {
	@Autowired
	private TestFeignClient testFeignClient;
	
	@RequestMapping("/test")
    public String getSentence() {
        return testFeignClient.test();
    }
}
