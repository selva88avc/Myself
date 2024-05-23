package com.stackroute.restsample.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "custom")
@Endpoint(id = "helpline")
public class HelplineEndpoint {

	
    @ReadOperation
    public Map<String, String> helplineEndpoint() {
        Map<String, String> result = new HashMap<>();
        result.put("message", "this is passenger service, running using tomcat, passenger common request mapping");
        return result;
    }
}
