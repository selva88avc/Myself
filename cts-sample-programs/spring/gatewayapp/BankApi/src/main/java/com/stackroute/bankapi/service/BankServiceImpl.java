package com.stackroute.bankapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.bankapi.exception.AccountAlreadyExist;
import com.stackroute.bankapi.exception.AccountIdNotFoundException;
import com.stackroute.bankapi.model.Account;
import com.stackroute.bankapi.repo.BankRepo;

@Service

public class BankServiceImpl implements BankService {
	
	@Autowired
	BankRepo repo;

	@Override
	public Account addAccount(Account acc) throws AccountAlreadyExist {
		
		
	Optional<Account> accopt=repo.findById(acc.getAccountNo());
		 
	if(accopt.isEmpty())
	 return repo.save(acc);
	else
		throw new AccountAlreadyExist("duplicate accoutn no");
	}

	@Override
	public List<Account> viewAccounts() {
		 
		return repo.findAll();
	}

	@Override
	public boolean deleteAccount(int id) throws AccountIdNotFoundException {
		
	Optional<Account> accopt=repo.findById(id);
	if(accopt.isPresent())
	{
		repo.deleteById(id);
		return true;
	}
	else
		 throw new AccountIdNotFoundException("invalid id");
	}

	@Override
	public Account update(Account acc) throws AccountIdNotFoundException {
		Optional<Account> accopt=repo.findById(acc.getAccountNo());
		if(accopt.isPresent())
		{
			repo.save(acc);
			return acc;
		}
		else
			 throw new AccountIdNotFoundException("invalid id");
		}

	@Override
	public List<Account> viewLowBalance(int minimum) {
		return repo.findAccountWithLowBalance(minimum);
	 
	}
	 

}
