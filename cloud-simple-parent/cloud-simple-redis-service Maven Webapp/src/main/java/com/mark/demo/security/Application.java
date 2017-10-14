package com.mark.demo.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/*
*hxp(hxpwangyi@126.com)
*2017年9月16日
*
*/
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@ServletComponentScan
@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
