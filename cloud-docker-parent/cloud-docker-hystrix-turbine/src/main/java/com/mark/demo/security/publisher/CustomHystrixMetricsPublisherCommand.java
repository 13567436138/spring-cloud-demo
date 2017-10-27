package com.mark.demo.security.publisher;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandMetrics;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisherCommand;

/*
*hxp(hxpwangyi@126.com)
*2017年10月26日
*
*/
public class CustomHystrixMetricsPublisherCommand implements HystrixMetricsPublisherCommand {

	public CustomHystrixMetricsPublisherCommand(HystrixCommandKey commandKey, HystrixCommandGroupKey commandGroupKey, HystrixCommandMetrics metrics, HystrixCircuitBreaker circuitBreaker, HystrixCommandProperties properties) {
       
    }
	@Override
	public void initialize() {

	}

}
