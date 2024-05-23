package com.stackroute.samplecircuit;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@RestController
public class SampleController {

	@Autowired
	SampleService service;
	@GetMapping("view")
	@CircuitBreaker(name="myservice",fallbackMethod="handleFailure")
	public ResponseEntity<?> getdata()
	{
	 List<Account> acc=service.getData();
	
	return new ResponseEntity<List>(acc,HttpStatus.OK);
		
	}
	public ResponseEntity<?> handleFailure(Exception e)
	{
		 
		
		 return new ResponseEntity("Bank Service is currently down. plz chk after some time " + LocalDate.now(),HttpStatus.OK);
	}


}
