package com.mark.demo.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/*
*hxp(hxpwangyi@126.com)
*2017年10月15日
*
*/
@EnableZuulProxy
@SpringBootApplication
@EnableHystrix  
@EnableHystrixDashboard 
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
