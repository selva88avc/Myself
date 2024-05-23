package com.stackroute.restsample.customendpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

//import com.stackroute.restsample.config.CustomConfiguration;

//@Component
//@Endpoint(id = "threshold")
//public class ThresholdEndpoint {
//
//    private final CustomConfiguration customConfiguration;
//
//    public ThresholdEndpoint(CustomConfiguration customConfiguration) {
//        this.customConfiguration = customConfiguration;
//    }
//
//    @ReadOperation
//    public int getThreshold() {
//        return customConfiguration.getThreshold();
//    }
//
//    @WriteOperation
//    public void setThreshold(int threshold) {
//        customConfiguration.setThreshold(threshold);
//    }
//}
