package com.mark.demo.security.config;

import org.springframework.context.annotation.Configuration;

import com.mark.demo.security.publisher.MysqlHystrixMetricsPublisher;
import com.netflix.hystrix.strategy.HystrixPlugins;

/*
*hxp(hxpwangyi@126.com)
*2017年10月26日
*
*/
@Configuration
public class HystrixConfig {
	public HystrixConfig(){
		HystrixPlugins.getInstance().registerMetricsPublisher(new MysqlHystrixMetricsPublisher());
	}
}
