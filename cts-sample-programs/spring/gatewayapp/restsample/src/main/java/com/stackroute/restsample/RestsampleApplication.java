package com.stackroute.restsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.stackroute.restsample.filter.PassengerFilter;

@SpringBootApplication
public class RestsampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestsampleApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean getfilter()
	{
		FilterRegistrationBean fbean=new FilterRegistrationBean();
		fbean.setFilter(new PassengerFilter());
		fbean.addUrlPatterns("/passenger/addpassenger","");
		return fbean;
		
	}
	
}
