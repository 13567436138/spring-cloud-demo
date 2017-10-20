package com.mark.demo.security.service.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mark.demo.security.base.PaginateResult;
import com.mark.demo.security.entity.Menu;
import com.mark.demo.security.service.MenuFeignService;

import feign.hystrix.FallbackFactory;

/*
*hxp(hxpwangyi@126.com)
*2017年10月20日
*
*/
@Component
public class MenuFeignFallBackFactory implements FallbackFactory<MenuFeignService> {

	@Override
	public MenuFeignService create(Throwable arg0) {
		return new MenuFeignServiceHystrix(arg0);
	}

}
