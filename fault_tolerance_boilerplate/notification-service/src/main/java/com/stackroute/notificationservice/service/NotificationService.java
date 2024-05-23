package com.stackroute.notificationservice.service;

import com.stackroute.notificationservice.model.Notification;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    Logger logger = LoggerFactory.getLogger(NotificationService.class);
    @Autowired
    private RestTemplate restTemplate;

    @Value("${product.service.url}")
    private String productServiceUrl;

    // Handle Fault tolerance using @CircuitBreaker annotation
    // Using rest template make an api call to ProductController url /product/{id}
    @CircuitBreaker(name="notificationService",fallbackMethod="fallback")
    public Notification notifyProductUpdate(int productId) {
        Notification notification= new Notification();
        String url=productServiceUrl+"/product/"+productId;
        notification=restTemplate.getForEntity(url,Notification.class,productId).getBody();
        return notification;
    }

    // log error message and productId as fallback and return empty object
    public Notification fallback(int productId, Exception e) {
        // Log the error
        logger.error("Error in calling product api",e);
        // Return a response with information about the failure
        return new Notification();
    }
}
