package com.stackroute.service;


import com.stackroute.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private Logger logger= LoggerFactory.getLogger(KafkaService.class);
    private String topic="loctopic";
    /*
    Method to trigger kafka send
     */
    public boolean updateLocation(String location){
        // Send location using kafka send() providing appropriate topic name
        kafkaTemplate.send(topic,location);
        this.logger.info("location produced");
        return true;
    }
}
