package com.stackroute.samplecircuit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class SampleService {
	
	//
	public List<Account> getData()
	{
	RestTemplate resttemp=new RestTemplate();
	 List<Account> accounts=new ArrayList();
String url="http://localhost:9098/account/view";
  accounts=resttemp.getForObject(url,List.class);

	return accounts;


	}
//	


}
