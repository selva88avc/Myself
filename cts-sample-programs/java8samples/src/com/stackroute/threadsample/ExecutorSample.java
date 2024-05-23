package com.stackroute.threadsample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Transfer implements Runnable
{
	
	BankAccount from,to;
	int amount;
	String type;
	Transfer(BankAccount from, BankAccount to, String type,int amount)
	{
		this.from=from;
		this.to=to;
		this.amount=amount;
		this.type=type;
	}

	public void run() {
		if(type.equals("withdraw"))
		{
			if(from.getBalance()<amount)
			{
				System.out.println("Insufficient ");
			}
			else
			{
			to.deposit(amount);
			from.withdraw(amount);
			System.out.println ("Fund transferred " +  Thread.currentThread().getName() + amount );
			}
		}
		
	}
	
}

public class ExecutorSample {

	public static void main(String[] args) {
		 
		BankAccount acc1=new BankAccount(5000);
		BankAccount acc2=new BankAccount(2000);
		
		ExecutorService executor=Executors.newFixedThreadPool(5);
		
		// non blocking call 
		Future fut=executor.submit(new Transfer(acc1,acc2,"withdraw",200));
		
		executor.submit(new Transfer(acc1,acc2,"deposit",1200));
		
		//executor.excute()
		
		System.out.println("view cusotmer data");
		
		if(fut.isDone())
		{
			
		}
		
		

	}

}
