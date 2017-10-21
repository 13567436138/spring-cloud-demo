package com.mark.demo.security.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mark.demo.security.entity.Resource;
import com.mark.demo.security.service.hystrix.ResourceFeignFallBackFactory;
import com.mark.demo.security.service.hystrix.ResourceFeignServiceHystrix;

/*
*hxp(hxpwangyi@126.com)
*2017年9月22日
*
*/
@FeignClient(name="resource",url="http://localhost:9999/service/resource",fallbackFactory=ResourceFeignFallBackFactory.class)
@RequestMapping("/service/resource")
public interface ResourceFeignService {
	@RequestMapping("/findAll")
	List<Resource> findAll();
}
