package com.stackroute.orders;

// o(log n)
//o(n)
public class Countdigits {
	
	static int countDigit(int n)
	{
		int count=0;
	 
		while(n>0)
		{
			n/=10;
			count++;
		}
		
		return count;
		
	}

	public static void main(String[] args) {
	 int number=348;
	 int result=countDigit(number);
	 System.out.println(result);
	}

}
