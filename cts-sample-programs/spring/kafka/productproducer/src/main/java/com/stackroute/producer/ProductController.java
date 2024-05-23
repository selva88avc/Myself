package com.stackroute.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	ProductServiceImpl service;
	
	
	@PostMapping("/product/add")
	public ResponseEntity<?> getData(@RequestBody Product product)
	{
		Product data=service.addProduct(product);
		return new ResponseEntity<Product>(data,HttpStatus.CREATED);
	}

}
