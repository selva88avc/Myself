package com.stackroute.samplegateway;



import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routeconfig {

	
	@Bean
	
		public RouteLocator customLocator(RouteLocatorBuilder builder)
		{
			return builder.routes()
					
				.route("bankapi", r -> r.path("/account/**")
						.uri("http://localhost:9098")).build();
					
		}
	}

