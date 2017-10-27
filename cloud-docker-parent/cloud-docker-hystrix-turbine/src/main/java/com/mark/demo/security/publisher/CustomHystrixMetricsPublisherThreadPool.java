package com.mark.demo.security.publisher;

import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolMetrics;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisherThreadPool;

/*
*hxp(hxpwangyi@126.com)
*2017年10月26日
*
*/
public class CustomHystrixMetricsPublisherThreadPool implements HystrixMetricsPublisherThreadPool {
	public CustomHystrixMetricsPublisherThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixThreadPoolMetrics metrics, HystrixThreadPoolProperties properties) {
        
    }
	@Override
	public void initialize() {

	}

}
