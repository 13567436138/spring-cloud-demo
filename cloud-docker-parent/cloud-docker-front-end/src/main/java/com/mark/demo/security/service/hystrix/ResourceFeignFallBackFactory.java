package com.mark.demo.security.service.hystrix;

import org.springframework.stereotype.Component;

import com.mark.demo.security.service.ResourceFeignService;

import feign.hystrix.FallbackFactory;

/*
*hxp(hxpwangyi@126.com)
*2017年10月20日
*
*/
@Component
public class ResourceFeignFallBackFactory implements FallbackFactory<ResourceFeignService> {

	@Override
	public ResourceFeignService create(Throwable arg0) {
		return new ResourceFeignServiceHystrix(arg0);
	}

}
