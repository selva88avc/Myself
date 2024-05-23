package com.stackroute.restsample.config;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component

@Endpoint(id = "custom")
public class CustomEndpoint {

    @ReadOperation
    public Map<String, String> customEndpoint() {
        Map<String, String> result = new HashMap<>();
        result.put("message", "this is passenger service, running using tomcat, passenger common request mapping");
        return result;
    }
}
