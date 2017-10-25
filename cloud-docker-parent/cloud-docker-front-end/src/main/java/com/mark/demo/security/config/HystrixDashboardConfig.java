package com.mark.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.actuator.HasFeatures;
import org.springframework.cloud.netflix.hystrix.dashboard.HystrixDashboardConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.HystrixDashboardConfiguration.ProxyStreamServlet;
import org.springframework.cloud.netflix.hystrix.dashboard.HystrixDashboardController;
import org.springframework.cloud.netflix.hystrix.dashboard.HystrixDashboardProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
*hxp(hxpwangyi@126.com)
*2017年10月20日
*
*/
@Configuration
@EnableConfigurationProperties(HystrixDashboardProperties.class)
public class HystrixDashboardConfig {
	@Autowired
	private HystrixDashboardProperties dashboardProperties;

	@Bean
	public HasFeatures hystrixDashboardFeature() {
		return HasFeatures.namedFeature("Hystrix Dashboard", HystrixDashboardConfiguration.class);
	}

	@Bean
	public ServletRegistrationBean proxyStreamServlet() {
		ProxyStreamServlet proxyStreamServlet = new ProxyStreamServlet();
		proxyStreamServlet.setEnableIgnoreConnectionCloseHeader(dashboardProperties
				.isEnableIgnoreConnectionCloseHeader());
		return new ServletRegistrationBean(proxyStreamServlet, "/proxy.stream");
	}

	@Bean
	public HystrixDashboardController hsytrixDashboardController() {
		return new HystrixDashboardController();
	}
}
