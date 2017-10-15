package com.mark.demo.security.config;

import java.util.concurrent.Executors;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zipkin.storage.StorageComponent;
import zipkin.storage.mysql.MySQLStorage;
import zipkin.storage.mysql.MySQLStorage.Builder;

/*
*hxp(hxpwangyi@126.com)
*2017年10月15日
*
*/
@Configuration
public class ZipkinConfig {
	@Bean
	public StorageComponent storage(DataSource dataSource){
		return MySQLStorage.builder().datasource(dataSource).executor(Executors.newFixedThreadPool(10)).build();
	}
}
