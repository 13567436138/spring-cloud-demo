package com.mark.demo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import com.mark.demo.security.utils.JedisUtils;

/*
*hxp(hxpwangyi@126.com)
*2017年9月16日
*
*/
@Configuration
public class UtilConfig {
	
	@Bean
	public JedisUtils jedisUtil(RedisTemplate<String, Object> redisTemplate){
		JedisUtils jedisUtil=new JedisUtils();
		jedisUtil.setRedisTemplate(redisTemplate);
		return jedisUtil;
	}
}
