package com.mark.demo.security.service.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mark.demo.security.entity.Resource;
import com.mark.demo.security.service.ResourceFeignService;

/*
*hxp(hxpwangyi@126.com)
*2017年10月20日
*
*/
public class ResourceFeignServiceHystrix implements ResourceFeignService {
	private Throwable throwable;
	
    public ResourceFeignServiceHystrix(Throwable throwable){
    	this.throwable=throwable;
    }
	@Override
	public List<Resource> findAll() {
		return new ArrayList<Resource>();
	}

}
