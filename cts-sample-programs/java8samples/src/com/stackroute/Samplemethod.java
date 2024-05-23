package com.stackroute;

import java.util.ArrayList;

interface iBook
{
	
	String viewDetails(int price);
}

interface iDigital
{
	boolean showData(int pri);
}
public class Samplemethod {

	public static void main(String[] args) {
 
		iBook book=Product::setStatus;
		iDigital digit=new Product()::view;
		
		System.out.println(book.viewDetails(3000));
		
		
		System.out.println(digit.showData(2000));
		
		ArrayList<Integer> salaries=new ArrayList<Integer>();
		salaries.add(600000);
		salaries.add(250000);
		salaries.add(1400000);
		salaries.add(200000);
		
		salaries.forEach( System.out::println);
	}

}
