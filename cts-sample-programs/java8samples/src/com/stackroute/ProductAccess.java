package com.stackroute;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
 

public class ProductAccess {

	public static void main(String[] args) {
 
		ArrayList<Product> products=new ArrayList<Product>();
		products.add(new Product("Speaker",5000));
		products.add(new Product("Mouse",450));
		products.add(new Product("Monitor",20000));
		
		
		ArrayList<FoodProduct> foodlist=new ArrayList<FoodProduct>();
		
		Function<Product,String> funproduct=(prd)->{
			if(prd.getPname().startsWith("M"))
				return "Standard Price";
			else
				return "Offers Allowed";
			
		};
		
		foodlist.forEach( (prd)->
		{


		String str=funproduct.apply(prd);


		System.out.println("Product name " + prd.getPname() + str);
		
		});
		
		
	Product product=	new Product("Speaker",5000);
	
		

											
		BiFunction<Product,String,Boolean> funproduct2= (prd,str)->prd.getPname().contains(str);
		
		
		products.forEach(
		(prd)->
		{


//			String str=funproduct.apply(prd);


//			System.out.println("Product name " + prd.getPname() + str);
			
		}
		
	);
		
		
//		if( funproduct2.apply(product, "Sp"))
//			System.out.println("Exist");
//		else
//			
//			System.out.println("Not exist");
		
		
		
		//	Comparator<Product> comparater=			
											
		// abstract method compareTo(obj,obj) returns int
											
	 // sort based on product name 
											
	Comparator<Product> compartorobj= (first,second)->
											{
										return	first.getPname().compareTo(second.getPname());
											};
											
											
						 			
		//products.sort(compartorobj);	
		
		products.sort((first,second)->first.getPname().compareTo(second.getPname()));
											 
		
	 
		System.out.println(products);
		
		
    
		
		 
//		
//			products.forEach(
//						(prd)->
//						{
		 
//							String str=funproduct.apply(prd);
		 
		
//							System.out.println("Product name " + prd.getPname() + str);
//						}
//					
//					
//					);
			
			
											
		}
	
	     

}
