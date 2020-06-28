package bg.softuni.shopping.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bg.softuni.shopping.web.filters.BaseAuthorizationFilter;


@Configuration
public class WebMvcConfig {
//	ERROR WITH EMBEDDED TOMCAT
//	@Bean
//	public FilterRegistrationBean<BaseAuthorizationFilter> commonFilter() {
//		FilterRegistrationBean<BaseAuthorizationFilter> authFilterBean = new FilterRegistrationBean<>();
//		authFilterBean.addUrlPatterns("/home", "/products/*");
//		return authFilterBean;
//	}
}
