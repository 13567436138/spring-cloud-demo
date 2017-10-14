package com.mark.demo.security.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mark.demo.security.entity.Resource;

/*
*hxp(hxpwangyi@126.com)
*2017年9月22日
*
*/
@FeignClient("resourceService")
@RequestMapping("/service/resource")
public interface ResourceFeignService {
	@RequestMapping("/findAll")
	List<Resource> findAll();
}
