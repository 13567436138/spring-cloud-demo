package com.mark.demo.security.publisher;

import com.netflix.hystrix.HystrixCollapserKey;
import com.netflix.hystrix.HystrixCollapserMetrics;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisherCollapser;

/*
*hxp(hxpwangyi@126.com)
*2017年10月26日
*
*/
public class CustomHystrixMetricsPublisherCollapser implements HystrixMetricsPublisherCollapser {
	public CustomHystrixMetricsPublisherCollapser(HystrixCollapserKey collapserKey, HystrixCollapserMetrics metrics, HystrixCollapserProperties properties) {
        
    }
	@Override
	public void initialize() {

	}

}
