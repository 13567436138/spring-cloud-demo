package com.mark.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/*
*hxp(hxpwangyi@126.com)
*2017年10月24日
*
*/
@SpringCloudApplication
@EnableAutoConfiguration
@EnableZuulServer
@EnableHystrix  
@EnableHystrixDashboard 
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
