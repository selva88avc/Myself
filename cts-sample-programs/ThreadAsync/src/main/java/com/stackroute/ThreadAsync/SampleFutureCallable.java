package com.stackroute.ThreadAsync;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class AccountDetails implements Callable<String>
{
	public String call() throws Exception {
		 
		Thread.sleep(3000);
		
		return "1000 customer data returned";
	}
}

class TransactionStatus implements Callable<Boolean>
{

	public Boolean call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}

public class SampleFutureCallable {

	public static void main(String[] args) {
	 ExecutorService accountservice=Executors.newFixedThreadPool(3);
	 
	Future<String> accountfuture=accountservice.submit(new AccountDetails());
								// accountservice.submit
	
	
	try {
		 
		String result=accountfuture.get();
		System.out.println("Result from async call is  " + result);
		 
	} 
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	
	accountservice.shutdown();
	}

}
