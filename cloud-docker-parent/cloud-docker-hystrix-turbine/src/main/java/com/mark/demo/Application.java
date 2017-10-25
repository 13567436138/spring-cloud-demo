package com.mark.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/*
*hxp(hxpwangyi@126.com)
*2017年10月25日
*
*/
@SpringCloudApplication
@EnableHystrixDashboard
@EnableTurbine
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
