package com.stackroute.bankapi.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.bankapi.exception.AccountAlreadyExist;
import com.stackroute.bankapi.exception.AccountIdNotFoundException;
import com.stackroute.bankapi.model.Account;
import com.stackroute.bankapi.service.BankService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BankControllerTest {
	
	
	@MockBean
	BankService bankservice;
	
	
	@InjectMocks
	BankController passcontrol;
	
	MockMvc mockmvc;
	
	Account account=new Account();
	
	List<Account> accounts=new ArrayList();

	@BeforeEach
	public void initializedata()
	{
		MockitoAnnotations.openMocks(this);
		
		mockmvc=MockMvcBuilders.standaloneSetup(passcontrol).build();
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
	public void whenaddaccountstoredsuccess() throws Exception
	{
		Mockito.when(bankservice.addAccount(account)).thenReturn(account);
	 
		mockmvc.perform(MockMvcRequestBuilders.post("/account/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content(convertObject(account))
						)
					.andExpect(MockMvcResultMatchers.status().isCreated());
		
	verify(bankservice,times(1)).addAccount(any());
		
	}
	private String convertObject(Object obj) throws JsonProcessingException
	{
		ObjectMapper objmap=new ObjectMapper();
	return	objmap.writeValueAsString(obj);
		
	}
	
	
    @Test
    public void testSaveProduct() throws AccountAlreadyExist {
    	Account account1=new Account();
        when(bankservice.addAccount(account)).thenReturn(account1);

        ResponseEntity<?> response = passcontrol.addAccount(account);

        verify(bankservice, times(1)).addAccount(account);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(account1, response.getBody());
    }

	
	@Test
	public void whenaddpassengeraddthenfailure() throws Exception
	{
	//	Mockito.when(passengerservice.addPassenger(any())).thenThrow(IdAlreadyExistException.class);
		
		Mockito.when(bankservice.addAccount(any())).thenThrow(new  AccountAlreadyExist("Duplicate id"));
		
		mockmvc.perform(MockMvcRequestBuilders.post("/account/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content(convertObject(account))
						)
						.andExpect(MockMvcResultMatchers.status().isConflict())
					//	   .andExpect(MockMvcResultMatchers.content().string("Duplicate id"))
						 .andDo(MockMvcResultHandlers.print());
		
     //   verify(passengerservice,times(0)).addPassenger(any());

		
	}

	
	@Test
	public void whendeletethensuccess() throws Exception
	{
		Mockito.when(bankservice.deleteAccount(10)).thenReturn(true);
		
		mockmvc.perform(MockMvcRequestBuilders.delete("/account//delete/10")
					.contentType(MediaType.APPLICATION_JSON)
						)
					.andExpect(MockMvcResultMatchers.status().isOk());
					
		
	}
	
	@Test
	public void whendeletethenfail() throws Exception
	{
		Mockito.when(bankservice.deleteAccount(anyInt())).thenThrow(AccountIdNotFoundException.class);
		
		mockmvc.perform(MockMvcRequestBuilders.delete("/account//delete/10")
					.contentType(MediaType.APPLICATION_JSON)
						)
					.andExpect(MockMvcResultMatchers.status().isNotFound());
					
		
	}
	
	@Test
	public void whenflightpricegiventhenreturnpassenger() throws Exception
	{
Mockito.when(bankservice.viewLowBalance(2000)).thenReturn(accounts);
		
		
		mockmvc.perform(MockMvcRequestBuilders.get("/account/viewbybalance/2000")
				.contentType(MediaType.APPLICATION_JSON)
				 
				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				 .andDo(MockMvcResultHandlers.print());
		
		verify(bankservice,times(1)).viewLowBalance(2000);
	}
	
}
