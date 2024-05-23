package com.stackroute.streamsample;

import java.util.ArrayList;

public class ShoppingRepo {

	static ArrayList<Shopping> shoppers=new ArrayList<Shopping>();
	
	
	public static ArrayList getShoppers()
	{
		shoppers.add(new Shopping("Ram","Blore","Chocolates",4000,false,5));
		shoppers.add(new Shopping("Vasu","Blore","Books",24000,true,20));
		shoppers.add(new Shopping("Abc","Blore","Books",24000,true,20));
		shoppers.add(new Shopping("Paul","Blore","Groceries",6000,true,5));
		shoppers.add(new Shopping("Lal","Delhi","Chocolates",8000,true,10));
		shoppers.add(new Shopping("Annu","Mumbai","Books",14000,false,20));
		return shoppers;

	}
}



  

