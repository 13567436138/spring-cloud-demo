package com.mark.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.sleuth.metric.SpanMetricReporter;
import org.springframework.cloud.sleuth.zipkin.HttpZipkinSpanReporter;
import org.springframework.cloud.sleuth.zipkin.ZipkinProperties;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import zipkin.Span;

/*
*hxp(hxpwangyi@126.com)
*2017年10月26日
*
*/
@Configuration
public class ZipKinConfig {
	@Autowired
	private EurekaClient eurekaClient;
	  
	@Autowired
	private SpanMetricReporter spanMetricReporter;
	  
	@Autowired
	private ZipkinProperties zipkinProperties;
	  
	//@Value("${spring.sleuth.web.skipPattern}")
	//private String skipPattern;
	
	@Value("${spring.zipkin.service.name}")
	private String zipKinServiceName;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	 
	@Bean
	public ZipkinSpanReporter makeZipkinSpanReporter() {
	    return new ZipkinSpanReporter() {
	        private HttpZipkinSpanReporter delegate;
	        private String baseUrl;
	 
	        @Override
	        public void report(Span span) {
	  
	            InstanceInfo instance = eurekaClient
	              .getNextServerFromEureka(zipKinServiceName, false);
	            if (!(baseUrl != null && 
	              instance.getHomePageUrl().equals(baseUrl))) {
	                baseUrl = instance.getHomePageUrl();
	                delegate = new HttpZipkinSpanReporter(restTemplate(),baseUrl,
	                  zipkinProperties.getFlushInterval(), 
	                  spanMetricReporter);
	  
	                //if (!span.name.matches(skipPattern)) 
	                delegate.report(span);
	            }
	        }
	    };
	}
}
