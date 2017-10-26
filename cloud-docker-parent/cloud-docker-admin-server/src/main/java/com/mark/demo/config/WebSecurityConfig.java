package com.mark.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
*hxp(hxpwangyi@126.com)
*2017年10月22日
*
*/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll();  
        http.logout().logoutUrl("/logout");
        http
                .csrf().disable()
                .authorizeRequests()  
                .antMatchers("/login.html", "/**/*.css", "/img/**", "/third-party/**").permitAll()
                .antMatchers("/api/**").permitAll().antMatchers("/**")  
                .authenticated()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .and()
                .logout()
                .and()
                .httpBasic();
    }

}
