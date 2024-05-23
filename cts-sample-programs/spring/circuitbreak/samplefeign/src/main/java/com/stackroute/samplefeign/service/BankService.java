package com.stackroute.samplefeign.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stackroute.samplefeign.model.Account;

@FeignClient("bankapi")
public interface BankService {

	@RequestMapping(method=RequestMethod.GET,value="/account/view")
	public List<Account> getaccounts();
}
