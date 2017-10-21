package com.mark.demo.cloud.eureka.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
*hxp(hxpwangyi@126.com)
*2017年9月19日
*
*/
@SpringBootApplication
@EnableEurekaServer
@RestController
@RefreshScope
public class Application {
	@Value("${name:World!}") String name ;

    @RequestMapping("/hello")
    public String home(){
        return "Hello " + name;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
