package com.stackroute.bankapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.bankapi.exception.AccountAlreadyExist;
import com.stackroute.bankapi.exception.AccountIdNotFoundException;
import com.stackroute.bankapi.model.Account;
import com.stackroute.bankapi.service.BankService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/account")
public class BankController {
	
	@Autowired
	BankService bankservice;
	
	@PostMapping("/add")
	//  @Tag(name = "Add", description = "Adding account details")

	public ResponseEntity<?> addAccount(@RequestBody Account acc)
	{
		Account accresult;
		try {
			accresult = bankservice.addAccount(acc);
			return new ResponseEntity<Account> (accresult,HttpStatus.CREATED);
		} catch (AccountAlreadyExist e) {
			 
			return new ResponseEntity<String>("Accound no already exist" ,HttpStatus.CONFLICT);
		}
		
	}
	
	@GetMapping("/view")
   @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Account.class), mediaType = "application/json") })

	public ResponseEntity<?> viewall()
	{
		List<Account> accounts=bankservice.viewAccounts();
		return new ResponseEntity<List>(accounts,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{accountid}")
	//@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<?> delete (@PathVariable("accountid") int accid)  
	{
		
		boolean res;
		try {
			res = bankservice.deleteAccount(accid);
			return new ResponseEntity<String> ("deleted",HttpStatus.OK);
		} catch (AccountIdNotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>("Accound no already exist" ,HttpStatus.NOT_FOUND);
		}
	 
		 
		
	}
	@GetMapping("/viewbybalance/{balance}")
	public ResponseEntity<?> viewbybalance(@PathVariable("balance") int balance)
	{
		List<Account> accounts=bankservice.viewLowBalance(balance);
		return new ResponseEntity<List>(accounts,HttpStatus.OK);
		
	}
	
	@Hidden
	@PutMapping("/update")
	
	public Account update (@RequestBody Account acc) throws AccountIdNotFoundException
	{
		Account accresult=bankservice.update(acc);
		return accresult;
	
	}
	
	
}
