package com.stackroute.orders;;

public class NaturalNum {

	//o(1)
    public static int sumOfN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input should be a non-negative integer");
        }

        return n * (n + 1) / 2;
    }

  //  o(n)
    int findSum(int n)
    {
       int sum = 0;  
       for (int x=1; x<=n; x++) 
    sum = sum + x; // n times
       return sum;
    }

    
    public static void main(String[] args) {
        int n = 10; // Change this value to calculate sum for a different 'n'

        int sum = sumOfN(n);
        System.out.println("The sum of the first " + n + " natural numbers is: " + sum);
    }
}