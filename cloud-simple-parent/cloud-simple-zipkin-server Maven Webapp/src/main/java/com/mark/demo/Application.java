package com.mark.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import zipkin.server.EnableZipkinServer;

/*
*hxp(hxpwangyi@126.com)
*2017年10月15日
*
*/
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
