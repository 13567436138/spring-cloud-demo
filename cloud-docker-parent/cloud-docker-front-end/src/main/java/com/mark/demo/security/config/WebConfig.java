package com.mark.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mark.demo.security.interceptor.CSRFHandlerInterceptor;
import com.mark.demo.security.interceptor.CSRFTokenManager;
import com.mark.demo.security.session.RedisSessionManager;

/*
*hxp(hxpwangyi@126.com)
*2017年10月20日
*
*/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	@Autowired
	private CSRFTokenManager csrfTokenManager;
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new EmbeddedServletContainerCustomizer(){
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
                container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
                container.addErrorPages(new ErrorPage(java.lang.Throwable.class,"/error/500"));
            }
        };
    }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(csrfHandlerInterceptor());
	}
	
	@Bean
	public CSRFHandlerInterceptor csrfHandlerInterceptor(){
		CSRFHandlerInterceptor interceptor=new CSRFHandlerInterceptor();
		interceptor.setCsrfTokenManager(csrfTokenManager);
		return interceptor;
	}
	
	@Bean 
	public CSRFTokenManager csrfTokenManager(RedisSessionManager redisSessionManager ){
		CSRFTokenManager manager=new CSRFTokenManager();
		manager.setRedisSessionManager(redisSessionManager);
		return manager;
		
	}
}
