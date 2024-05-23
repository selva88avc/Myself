package com.stackroute.bankapi.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.bankapi.exception.AccountAlreadyExist;
import com.stackroute.bankapi.exception.AccountIdNotFoundException;
import com.stackroute.bankapi.model.*;

import com.stackroute.bankapi.repo.BankRepo;
import com.stackroute.bankapi.service.BankServiceImpl;
public class BankServiceTest {

	@Mock
	BankRepo dao;
	
	@InjectMocks
	BankServiceImpl  pservice;
	
	Account account=new Account();
	
	List<Account> accounts=new ArrayList<Account>();
	
	@BeforeEach
	public void initializedata()
	{
		MockitoAnnotations.openMocks(this);
		
	 account.setAccountNo(10);
	 account.setName("Dan");
	 account.setBalance(4000);
		
	 accounts.add(account);
		
		Account account1=new Account();
		
		 account1.setAccountNo(20);
		 account1.setName("Vimala");
		 account1.setBalance(6000);
		
		 accounts.add(account1);
		
		
	}
	
	@Test
	public void whenaddAccountthensuccess() throws AccountAlreadyExist  
	{
		
		//stub
		when( dao.save(account)).thenReturn(account);
		
		
		
		//when
		Account storedacc=	pservice.addAccount(account);
	
	
	//then
	
	assertEquals(storedacc.getName(),"Dan");
	
	verify( dao,times(1)).findById(account.getAccountNo());
	verify( dao,times(1)).save(account);
		
	}
	
	
	
	@Test
	public void whenaddthenfailedwithduplicate()
	{
		//stub
		when( dao.findById(10)).thenReturn(Optional.of(account));
		
		
		
		assertThrows(AccountAlreadyExist.class,()->pservice.addAccount(account));
		
	}
	
	
	
	@Test
	public void whenviewthenall()
	{
		when(dao.findAll()).thenReturn(accounts);
		
		List<Account> acclist=	pservice.viewAccounts();
;
		assertEquals(acclist,accounts); 
	}
//	@Test
//	public void wnenviewbyidthensucess()
//	{
//		
//		//when(passdao.findByFlightAndSeat(any(),any()).thenReturn(Accounts);
//		when ( dao.findByflightName(any())).thenReturn(Accounts);
//		
//		List<Account> passlist=	pservice.getAccountByFlight("F110");
//		
//				assertEquals(passlist,Accounts); 
//		
//		
//		
//	}
	
	@Test
	public void whendeletebyidthensuccess() throws AccountIdNotFoundException
	{
		when( dao.findById(account.getAccountNo())).thenReturn(Optional.of(account));
		
		boolean result=pservice.deleteAccount(account.getAccountNo());
		
		
		assertTrue(result);
		verify( dao,times(1)).deleteById(account.getAccountNo());
		
		
	}
	
	@Test
	public void whendetetethenerros()
	{
		when(dao.findById(account.getAccountNo())).thenReturn(Optional.empty());
		
		assertThrows(AccountIdNotFoundException.class,()->pservice.deleteAccount(account.getAccountNo()));
		

		verify( dao,times(0)).deleteById(10);
	}
	
	@Test
	public void getminibalancesuccess()
	{
		when(dao.findAccountWithLowBalance(2000)).thenReturn(accounts);
		
		List<Account> results=pservice.viewLowBalance(2000);
		
		assertEquals(results,accounts);
		
	}
	
	
}
