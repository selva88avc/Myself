//package com.stackroute;
//
//import java.util.ArrayList;
//import java.util.function.Predicate;
//
//@FunctionalInterface
//interface calcuTax
//{
//	int compar(int amount);
//}
//
// 
//
//
//
//
//public class SampleLambda {
//
//	public static void main(String[] args) {
//		 
//	ArrayList<Integer> salaries=new ArrayList<Integer>();
//	salaries.add(600000);
//	salaries.add(250000);
//	salaries.add(1400000);
//	salaries.add(200000);
//
//		 
//     calcuTax calcu= (amt)->{
//    	 					if(amt<700000)
//    	 						return 0;
//    	 					else
//    	 						return amt*18/100;
//     			};
//     			
//     			
//     calcuTax calcu2024= (amt)->{
//			if(amt<700000)
//					return amt*10/100;
//				else
//					return amt*20/100;
//	};
//	
//	
//    		 
//     			displayTax(salaries,calcu);
//     			
//     	Predicate<Integer> predicate=(salary)-> salary.intValue()<300000;
//     	
//     			salaries.removeIf(predicate);
//     			
//     			System.out.println("After remove");
//     			salaries.forEach(data->System.out.println(data));
//     			
//     			
////     			displayTax(salaries,(amt)->{
////    	 					if(amt<700000)
////    	 						return 0;
////    	 					else
////    	 						return amt*18/100;
////     			});
//	
//	}
//	
//	
//	static void displayTax(ArrayList data,calcuTax calcu)
//	{
////		
////		data.forEach(
////				(dt)-> 
////				{
////					int result=calcu.findTax((int)dt);
////					System.out.println(result);
////				}
////				
////				);
////		
//		
//		
//	
//	}
//
//}
