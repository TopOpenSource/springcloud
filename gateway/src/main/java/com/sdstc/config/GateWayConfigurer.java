package com.sdstc.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfigurer{

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/api/system/**").uri("lb://system"))
				.route(p -> p.path("/api/baseservice/**").uri("lb://baseservice"))
				.route(p -> p.path("/api/order/**").uri("lb://order"))
				.route(p -> p.path("/api/project/**").uri("lb://project"))
				.build();
	}
}