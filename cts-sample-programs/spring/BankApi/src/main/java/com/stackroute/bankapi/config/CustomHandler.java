package com.stackroute.bankapi.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stackroute.bankapi.exception.AccountIdNotFoundException;

import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class CustomHandler {
	
	@ExceptionHandler(AccountIdNotFoundException.class)
	
	public ResponseEntity<String> handleNotfound(HttpServletResponse res)
	{
		return new ResponseEntity<String>("Given id not exist ", HttpStatus.NOT_FOUND);
	}
	
	
	//@ExceptionHandler(MethodArgumentNotValidException.class)
	
	

}
