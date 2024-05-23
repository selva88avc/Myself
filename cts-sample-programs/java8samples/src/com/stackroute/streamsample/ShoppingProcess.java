package com.stackroute.streamsample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ShoppingProcess {
	
	static ArrayList<Shopping> shoppers=ShoppingRepo.getShoppers();

	public static void main(String[] args) {
	
		
	//	getUserCity("Delhi");
		
		//delayedData();
//		sortCustomer("Blore");
//		
//		getMap();
		
	//	getNames();
		
	Optional<List> result=getOptional();
	
	
	}

	
	//get the list of users from given city
	
	static void getUserCity(String city)
	{
	List<Shopping> result=shoppers.stream().filter( shop-> shop.getCity().equals(city)).collect(Collectors.toList());
	//result.forEach(System.out::println);
	
	
//	shoppers.stream().filter( shop-> shop.getCity().equals(city)).collect(Collectors.toList()).forEach(System.out::println);
	

	}
	
	
	// find the customer whose delivery  got delayed
	
	static void delayedData()
	{
	int optdays=	shoppers.stream().mapToInt( shop-> shop.getDeliverydays() ).max().orElse(0);
	
	//shoppers.stream().filter( shop->shop.getDeliverydays()==optdays).collect(Collectors.toList()).forEach(System.out::println);

	
	//	final int maxdays ;
//	if(optdays.isPresent())
//		maxdays=optdays.getAsInt();
//	//System.out.println(maxdays);
	
	//
	
	
	Function<Shopping,Integer> fundelay=(shop)->shop.getDeliverydays();
	
	Optional optshopper=shoppers.stream().max(Comparator.comparing(fundelay));
	if(optshopper.isPresent())
	System.out.println(optshopper.get());
	
	
	}
	
	//get the list of customers from the given city sort using customername

	static void sortCustomer(String city)
	{
		shoppers.stream().filter( shop-> shop.getCity().equals(city))
				.sorted(Comparator.comparing(Shopping::getUserName).reversed()
						.thenComparing(Shopping::getProduct)
						)
				.collect(Collectors.toList()).forEach(System.out::println);
	}


	//get the map of customer with anme and city
	
	static void getMap()
	{
	Map<String,String> data=	shoppers.stream().skip(10).collect(Collectors.toMap(Shopping::getUserName, Shopping::getProduct));
	
	data.forEach( (k,v)->System.out.println("key " + k  + " value " + v));
	}
	
	//get the prepaid customers, name alone separated by ,
	
	static void getNames()
	{
	
	String name=	shoppers.stream().filter( shop->shop.isPaid=true)
						.map(shop->shop.getUserName())
						.collect(Collectors.joining(","));
	System.out.println(name);
	}

	
	static Optional<List> getOptional()
	{
	List<String> products=shoppers.stream().filter(shop->shop.getDeliverydays()<20)
			.map( shop-> shop.getProduct()).collect(Collectors.toList());
		

	return Optional.of(products);
	}
}
