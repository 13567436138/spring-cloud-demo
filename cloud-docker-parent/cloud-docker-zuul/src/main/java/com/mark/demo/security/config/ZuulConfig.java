package com.mark.demo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mark.demo.security.filter.CostomStaticResponseFilter;

/*
*hxp(hxpwangyi@126.com)
*2017年10月27日
*
*/
@Configuration
public class ZuulConfig {
	@Bean
	public CostomStaticResponseFilter costomStaticResponseFilter(){
		return new CostomStaticResponseFilter();
	}
}
