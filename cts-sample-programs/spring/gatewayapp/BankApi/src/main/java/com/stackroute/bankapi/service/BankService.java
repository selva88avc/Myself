package com.stackroute.bankapi.service;

import java.util.List;
 

import com.stackroute.bankapi.exception.AccountAlreadyExist;
import com.stackroute.bankapi.exception.AccountIdNotFoundException;
import com.stackroute.bankapi.model.Account;

public interface BankService {
	
		Account addAccount(Account acc)  throws AccountAlreadyExist;
		List<Account> viewAccounts();
		boolean deleteAccount(int id) throws AccountIdNotFoundException;
		Account update(Account acc) throws AccountIdNotFoundException;
		
		List<Account> viewLowBalance(int minimum);
		
		
}
