package com.stackroute.authentication.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.authentication.config.JwtGenerator;
import com.stackroute.authentication.exception.UserNotFoundException;
import com.stackroute.authentication.model.UserInfo;
import com.stackroute.authentication.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin
@RestController
@RequestMapping("/authorize")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/register")
	public ResponseEntity adduser(@RequestBody UserInfo userinfo)
	{
	
		UserInfo userobj=userservice.registerUser(userinfo);
		if (userobj!=null)
			return new ResponseEntity<UserInfo>(userobj,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("duplicate id",HttpStatus.CONFLICT);
			
	}

	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserInfo userinfo) throws UserNotFoundException
	{
	
		
		
		
		
	     if (userinfo.getUseremail() == null || userinfo.getPassword() == null) {
             throw new UserNotFoundException("email and password are null");
         }
     	boolean result=userservice.login(userinfo.getUseremail(), userinfo.getPassword());
//         if (result == false) {
//             throw new UserNotFoundException("Email / password mismatch");
//             
//         }

	
	if(result)
		{
			
		
//			 map=new HashMap();
//			map.put("token",mytoken);
			
			Map<String, String> mytoken= new JwtGenerator().generateToken(userinfo);
			return new ResponseEntity<Map>(mytoken,HttpStatus.OK);
			
		}
	
	else
		return new ResponseEntity("Invalid user",HttpStatus.UNAUTHORIZED);
	 
	 
	
	}
	
	
//	
//	private String generatetoken(UserInfo userinfo)
//	
//	{
//		long expiry=10_000_00;
//		
//		Map<String,Object> myclaims=new HashMap();
//		myclaims.put("user","mary");
//		myclaims.put("pwd","pass");
//		
//		
//		String token= Jwts.builder().setSubject(userinfo.getUseremail())
//						.setAudience("employee")
//						.setIssuedAt(new Date(System.currentTimeMillis()))
//						.setExpiration(new Date(System.currentTimeMillis()+expiry))
//						.signWith(SignatureAlgorithm.HS256, "cgijune")
//						.setClaims(myclaims)
//						.compact();
//						
//		return token;
//		
//	}
//	
	
	
	
	
	
	
	
	
	

}
