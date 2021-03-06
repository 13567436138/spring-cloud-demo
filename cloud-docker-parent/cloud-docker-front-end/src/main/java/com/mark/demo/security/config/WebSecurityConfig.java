package com.mark.demo.security.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mark.demo.security.interceptor.CSRFRequestDataValueProcessor;
import com.mark.demo.security.security.CustomAccessDecisionManager;
import com.mark.demo.security.security.CustomFilterSecurityInterceptor;
import com.mark.demo.security.security.CustomLogoutSuccessHandler;
import com.mark.demo.security.security.CustomSavedRequestAwareAuthenticationSuccessHandler;
import com.mark.demo.security.security.CustomUserDetailsService;
import com.mark.demo.security.security.CustomUsernamePasswordAuthenticationFilter;
import com.mark.demo.security.service.UserFeignService;
import com.mark.demo.security.session.RedisSessionManager;

/*
*hxp(hxpwangyi@126.com)
*2017年9月24日
*
*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private UserFeignService userService;
	@Autowired
	private RedisSessionManager redisSessionManager;
	@Autowired
	private CustomFilterSecurityInterceptor customFilterSecurityInterceptor;
	@Autowired
	private CustomLogoutSuccessHandler customLogoutSuccessHandler;
	@Autowired
	private CustomSavedRequestAwareAuthenticationSuccessHandler customSavedRequestAwareAuthenticationSuccessHandler;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private CustomAccessDecisionManager customAccessDecisionManager;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		LoginUrlAuthenticationEntryPoint entryPoint=new LoginUrlAuthenticationEntryPoint("/common/login/submitlogin");
		entryPoint.setUseForward(true);
		 http
		 	.addFilterBefore(customFilterSecurityInterceptor, FilterSecurityInterceptor.class)
		 	.addFilterAt(customUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
	        .authorizeRequests().accessDecisionManager(customAccessDecisionManager)  
	        .antMatchers("/js/**").permitAll()
	        .antMatchers("/css/**").permitAll()
	        .antMatchers("/common/login**").permitAll()
	        .antMatchers("/captcha**").permitAll()
	        .anyRequest().authenticated() 
	        .antMatchers("/admins/**").hasAuthority("ROLE_ADMIN")
	        .and()  
	        .csrf().disable()
	        .formLogin()  
	        .loginPage("/common/login")
	        .usernameParameter("userName").passwordParameter("password")  
	        .loginProcessingUrl("/common/login/submitlogin")
	        .successForwardUrl("/admins/indexes/index")
	        .failureForwardUrl("/common/login?error=true")
	        .permitAll()  
	        .successHandler(customSavedRequestAwareAuthenticationSuccessHandler)
	        .and()
	        .logout()  
	        .logoutSuccessUrl("/logout")
	        .logoutSuccessHandler(customLogoutSuccessHandler)
	        .permitAll()  
	        .invalidateHttpSession(true)
	        .and()
	        .exceptionHandling()
	        .authenticationEntryPoint(entryPoint)
	        .and()
	        .rememberMe()
	        .tokenValiditySeconds(1209600)
	        .and()
	        .sessionManagement()
	        .invalidSessionUrl("/common/login")
	        .maximumSessions(1)
	        .expiredUrl("/common/login?expire=true"); 
	}
	
	@Bean
	public CustomUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter()throws Exception{
		CustomUsernamePasswordAuthenticationFilter filter=new CustomUsernamePasswordAuthenticationFilter();
		filter.setUserService(userService);
		filter.setRedisSessionManager(redisSessionManager);
		filter.setAuthenticationManager(authenticationManager());
		filter.setFilterProcessesUrl("/common/login/submitlogin");
		filter.setAuthenticationSuccessHandler(customSavedRequestAwareAuthenticationSuccessHandler);
		filter.setAuthenticationFailureHandler(simpleUrlAuthenticationFailureHandler());
		return filter;
				
	}
	
	@Bean
	public SimpleUrlAuthenticationFailureHandler simpleUrlAuthenticationFailureHandler(){
		SimpleUrlAuthenticationFailureHandler handler=new SimpleUrlAuthenticationFailureHandler();
		handler.setDefaultFailureUrl("/common/login?error=code");
		return handler;
	}
	
	@Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        return daoAuthenticationProvider;
    }
	
   @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        ProviderManager authenticationManager = new ProviderManager(Arrays.asList(daoAuthenticationProvider()));
        authenticationManager.setEraseCredentialsAfterAuthentication(false);
        return authenticationManager;
    } 

	@Bean
	public CSRFRequestDataValueProcessor csrfRequestDataValueProcessor(){
		return new CSRFRequestDataValueProcessor();
	}
	
}
