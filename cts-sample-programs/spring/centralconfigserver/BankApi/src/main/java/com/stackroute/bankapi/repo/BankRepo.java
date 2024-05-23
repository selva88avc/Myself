package com.stackroute.bankapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackroute.bankapi.model.Account;

@Repository
public interface BankRepo extends JpaRepository<Account,Integer>{
	
	@Query("select acc from Account acc where acc.balance<?1")
	List<Account> findAccountWithLowBalance(int balance);
}
