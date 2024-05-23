package com.stackroute.samplefeign.controller;

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

@RestController
public class FeignController {

	
	@Autowired
	BankService service;
	
	@Autowired
	PassengerService pservice;
	
	@GetMapping("/client/user/view")
	public ResponseEntity<?> getdata()
	{
		List<Passenger> passengers=pservice.getpass();
		return new ResponseEntity<List>(passengers,HttpStatus.OK);
	}
	
	
	@GetMapping("/client/bank/view")
	public ResponseEntity<?> getBankdata()
	{
		List<Account> accounts=service.getaccounts();
		return new ResponseEntity<List> (accounts,HttpStatus.OK);
	}
}
