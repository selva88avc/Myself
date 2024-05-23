package com.stackroute.orders;

import java.util.Arrays;
// o (n log n)
public class SampleAnagram {

	public static boolean checkAnagram(String first,String second)
	{
		
		if(first.length()!=second.length())
			return false;
		
		
		char[] firstarr1=first.toCharArray();
		char[] secondarr2=second.toCharArray();
		/* o(n^2)
		 *  for(char -- firstarr1
		 * 			{
		 * 				for(char2 -- secondarr2)
		 * 		}
		 * }
		 * 
		 */
		
		// quick sort 
		Arrays.sort(firstarr1);
		Arrays.sort(secondarr2);
		
		return Arrays.equals(firstarr1,secondarr2);
	}
	
	
	public static void main(String[] args) {
	
		String str1="pot",str2="top";
		boolean result=checkAnagram(str1,str2);
		if(result)
			System.out.println("Yes Anagram");
		else
			
			System.out.println("Not an Anagram");

		
	}

}
