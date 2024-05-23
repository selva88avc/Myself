package com.stackroute.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class ProductServiceImpl {
	
	@Autowired
	ProductRepo repo;
	
	@Autowired
	Gson gson;
	
	@Autowired
	KafkaTemplate<String,String> kafkatemp;
	String topic="ctstopic";
   public Product addProduct(Product prodct)
   {
		  kafkatemp.send(topic,gson.toJson(prodct));
	  return repo.save(prodct);

   }
	
	
}
