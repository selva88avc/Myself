package com.stackroute.productservice.service;

import com.stackroute.productservice.model.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${notification.service.url}")
    private String notificationServiceUrl;


    // Handle Fault tolerance using @CircuitBreaker annotation
    // Using rest template make an api call to ProductController url /notify/product/{id}
    @CircuitBreaker(name="productService",fallbackMethod="fallback")
    public Product getProductInfo(int productId) {
        Product product= new Product();
        String url=notificationServiceUrl+"/notify/product/"+productId;
        product=restTemplate.getForEntity(url,Product.class,productId).getBody();
        return product;
    }

    // log error message and productId as fallback and return empty object
    public Product fallback(int productId, Exception e) {
        // Log the error
        logger.error("Error in calling notification api",e);
        // Return a response with information about the failure
        return new Product();
    }
}
