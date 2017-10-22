package com.mark.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.codecentric.boot.admin.config.EnableAdminServer;

/*
*hxp(hxpwangyi@126.com)
*2017年10月22日
*
*/
@SpringBootApplication
@EnableAdminServer
@EnableWebSecurity
@RestController  
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping("/security")  
    public String security() {  
        return "hello world security";  
    }  

}
