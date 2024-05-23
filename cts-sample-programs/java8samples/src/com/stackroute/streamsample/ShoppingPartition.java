package com.stackroute.streamsample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingPartition {

	public static void main(String[] args) {
		ArrayList<Shopping> shoppers=ShoppingRepo.getShoppers();
		
	Map<Boolean,Long> result=	shoppers.stream().collect(Collectors.partitioningBy(shop->shop.isPaid==true,
					Collectors.counting()));

	
	result.forEach( (k,v)-> System.out.println(k + " " + v ));
	}

}
