package com.mark.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

import com.mark.demo.security.anno.MyBatisDao;

/*
*hxp(hxpwangyi@126.com)
*2017年9月16日
*
*/
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@ServletComponentScan
@MapperScan(value="com.mark.demo.security.mapper",annotationClass=MyBatisDao.class)
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"com.mark.demo.security.service"})
@EnableHystrix  
@EnableHystrixDashboard 
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
