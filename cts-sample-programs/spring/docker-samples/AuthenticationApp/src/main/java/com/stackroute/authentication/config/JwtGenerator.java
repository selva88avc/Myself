package com.stackroute.authentication.config;

 

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stackroute.authentication.model.UserInfo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



	//@Service
	public class JwtGenerator  {

	    /**
	     * To get the property values
	     */
//	    @Value("${jwt.secret}")
//	    private String secret;
//
//	    @Value("${app.jwttoken.message}")
//	    private String message;


	    public Map<String, String> generateToken(UserInfo user) {
	         
	    	long expiry=10_000_00;
	        Map<String, Object> userdata = new HashMap<>();
	        
 	        userdata.put("id", user.getUseremail());
	        userdata.put("password", user.getPassword());
	   //     userdata.put("role", user.getRole());

	        String jwtToken = "";

 

	        jwtToken = Jwts.builder().setClaims(userdata)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis()+expiry))
	                .signWith(SignatureAlgorithm.HS256, "ctskey").compact();
	        
	        Map<String, String> jwtTokenMap = new HashMap<>();
	        jwtTokenMap.put("token", jwtToken);
	        jwtTokenMap.put("message", "token1");
	        return jwtTokenMap;
	    }
	}


