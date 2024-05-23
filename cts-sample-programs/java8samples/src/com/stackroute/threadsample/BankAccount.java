package com.stackroute.threadsample;

public class BankAccount {
	
	int balance;
	BankAccount(int balance)
	{
		this.balance=balance;
	}
	
	public void deposit(int amount)
	{
		balance+=amount;
	}
	public void withdraw(int amount)
	{
		balance-=amount;
	}

	public int getBalance()
	{
		return balance;
	}
}
