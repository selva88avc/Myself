package com.stackroute.notificationservice.controller;

import com.stackroute.notificationservice.model.Notification;
import com.stackroute.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Handle errors and return appropriate response entity
    @GetMapping("/product/{productId}")
    public ResponseEntity<?> notifyProductUpdate(@PathVariable int productId) {
        Notification notification = notificationService.notifyProductUpdate(productId);
        if(notification!=null){
            return new ResponseEntity<>(notification,HttpStatus.OK);
        } else {
            return new ResponseEntity<Notification>(notification, HttpStatus.NOT_FOUND);
        }
    }
}
