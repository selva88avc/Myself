package com.stackroute.orders;

//Given a array of numbers, find the index of an element which is greater than its left and right element.
 //given sorted array

 
  
// o(log n)
public class PeakElement {

    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array is empty or null");
        }

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // The peak element is likely to be on the left side
                high = mid;
            } else {
                // The peak element is likely to be on the right side
                low = mid + 1;
            }
        }

        return low; // 'low' now represents the index of a peak element
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 20, 34, 61, 70}; // Example array

        int peakIndex = findPeakElement(array);
        System.out.println("The index of the peak element is: " + peakIndex);
    }
}