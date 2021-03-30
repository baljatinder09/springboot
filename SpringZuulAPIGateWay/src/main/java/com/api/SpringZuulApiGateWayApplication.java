package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class SpringZuulApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZuulApiGateWayApplication.class, args);
	}

	@Bean
	public PreFilter getPreFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter getPostFilter() {
		return new PostFilter();
	}

	@Bean
	public RouteFilter getRouterFilter() {
		return new RouteFilter();
	}
	
	@Bean
	public ErrorFilter getErrorFilter()
	{
		return new ErrorFilter();
	}
}
