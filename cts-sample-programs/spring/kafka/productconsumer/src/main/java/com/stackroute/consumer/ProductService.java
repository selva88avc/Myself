package com.stackroute.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.google.gson.Gson;

@Configuration
public class ProductService {
	
	@Autowired
	Gson gson;
	
	@KafkaListener(topics="ctstopic",groupId="group_id")
	public void consume(String str)
	{
		String msgreceived=str;
		Product product=gson.fromJson(msgreceived,Product.class);
		System.out.println(product);
	}

}
