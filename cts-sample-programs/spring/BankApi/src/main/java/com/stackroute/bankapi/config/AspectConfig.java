package com.stackroute.bankapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
	
	@Bean
	public BankAspect getaspect()
	{
		return new BankAspect();
	}

}
