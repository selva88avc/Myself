package com.stackroute.streamsample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShoppingCollectors {

	public static void main(String[] args) {
		 
		
		ArrayList<Shopping> shoppers=ShoppingRepo.getShoppers();
		
		
		// get the  customers based on city
		
	Map<String,List<Shopping>> resultmap=	shoppers.stream().collect(Collectors.groupingBy( shop->shop.getCity()));
	
	//resultmap.forEach((k,v)-> System.out.println( " city " + k + " value " + v ));
	
	// get the  customer count based on city
	
	
	Map<String,Long> resultcount=shoppers.stream().collect(Collectors.groupingBy( shop->shop.getCity(),Collectors.counting()     ));
	
	//resultcount.forEach((k,v)-> System.out.println( " city " + k + " count " + v ));

	// find average deliverdays for each city
	
	
	Map<String,Double> resultavg=shoppers.stream().collect(Collectors.groupingBy(
									shop->shop.getCity() ,
									Collectors.averagingInt(Shopping::getDeliverydays)
									) 
								);//collect
	
	//resultavg.forEach((k,v)-> System.out.println( " city " + k + " average delivery days " + v ));
	
	//find maximum deliverday for each city
	
	Map<String,Optional<Shopping>> resultmax=shoppers.stream().filter(s->s.isPaid==true).collect(Collectors.groupingBy(
															shop->shop.getCity() ,
															Collectors.maxBy(Comparator.comparing(Shopping::getDeliverydays))
															)
									 ); //collect
	
	
	//resultmax.forEach((k,v)-> System.out.println( " city " + k + " Delayed delivery for customer  " + v.get() ));
	
	
	// group based on city , get the cutomername as list
	Map<String,List<String>> resultmapuser=		shoppers.stream().collect(Collectors.groupingBy(
											shop->shop.getCity() ,
											Collectors.mapping(shop->shop.getUserName(), Collectors.toList())
											)
									 );
			
	//resultmapuser.forEach((k,v)-> System.out.println( " city " + k + "   customer  name " + v ));	
	
	
//	chocolates - blore , delhi
//	books - blore, mumbai
//	groceries - blore
	Map<String,Map<String,List<String>>> resultcity=shoppers.stream().collect(Collectors.groupingBy(
									shop->shop.getProduct(),
									Collectors.groupingBy(shop->shop.getCity(),
									Collectors.mapping( shop->shop.getUserName(), Collectors.toList()))
									)
								);
	
	resultcity.forEach((k,v)-> System.out.println( " Product " + k + "   Sold at   " + v ));
	
	
	
		LinkedHashMap link=	shoppers.stream().collect(Collectors.groupingBy(
										shop->shop.getCity(),
										LinkedHashMap::new,
									 Collectors.toList()
									 )
									);
		
		link.forEach((k,v)-> System.out.println( " city " + k + "   count  " + v ));

	}

}


//Shopping object
//
//can return
//		
//		fields
//		methods
//		operatison and outcome based on fields
//		
//		count, price
//		
//			price*10/100
			
