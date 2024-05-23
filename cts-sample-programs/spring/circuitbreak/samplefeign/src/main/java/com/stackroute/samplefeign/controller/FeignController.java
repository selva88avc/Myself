package com.stackroute.samplefeign.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.samplefeign.model.Account;
import com.stackroute.samplefeign.model.Passenger;
import com.stackroute.samplefeign.service.BankService;
import com.stackroute.samplefeign.service.PassengerService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class FeignController {

	
	@Autowired
	BankService service;
	
	@Autowired
	PassengerService pservice;
	
	@GetMapping("/client/user/view")
	@CircuitBreaker(name="myservice",fallbackMethod="handleFailure")
	public ResponseEntity<?> getdata()
	{
		List<Passenger> passengers=pservice.getpass();
		return new ResponseEntity<List>(passengers,HttpStatus.OK);
	}
	
	
	@GetMapping("/client/bank/view")
	@CircuitBreaker(name="myservice",fallbackMethod="handleFailure")
	public ResponseEntity<?> getBankdata()
	{
		List<Account> accounts=service.getaccounts();
		return new ResponseEntity<List> (accounts,HttpStatus.OK);
	}


	public ResponseEntity<?> handleFailure(Exception e)
	{
		return new ResponseEntity<String>("Bank Service is currently down. plz chk after some time " + LocalDate.now(),HttpStatus.OK);
	}


}
