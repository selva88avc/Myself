package com.stackroute.ThreadAsync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SampleCompletable {

	public static void main(String[] args) {
		
		
		CompletableFuture<String> accountdata=CompletableFuture.supplyAsync( ()->{
						
					try {
						Thread.sleep(2000);
						//write code toupdate inside database
					}
					catch(Exception e)
					{
						
					}
						return "Db is updated";
				});
		
		CompletableFuture<Integer> userdata=CompletableFuture.supplyAsync( ()->{
			try {
				Thread.sleep(2000);
				//write code toupdate inside database
			}
			catch(Exception e)
			{
				
			}
				return 1000;
						
		});
		
	CompletableFuture<Void> resultobj=CompletableFuture.allOf(accountdata, userdata);
	
		try {
			resultobj.join();
		String data=accountdata.get();
		int users=	userdata.get();
		System.out.println("returned values are " + data  +  " " + users );
						
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Inside main method ");
		
		for (int i=0;i<=5;i++)
		{
			System.out.println("Welcome ");
		}
	}

}
