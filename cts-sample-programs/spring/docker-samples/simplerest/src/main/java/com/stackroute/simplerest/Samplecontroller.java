package com.stackroute.simplerest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Samplecontroller {
	
	@GetMapping("/view")
	public ResponseEntity<?> getall()
	{
		return new ResponseEntity<String>("Welcome to doc env",HttpStatus.OK);
	}

}
