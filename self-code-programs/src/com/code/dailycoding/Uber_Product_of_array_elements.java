package com.code.dailycoding;
/*
This problem was asked by Uber.

Given an array of integers, return a new array such that each
element at index i of the new array is the product of all the
numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected
output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1],
the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
 */
public class Uber_Product_of_array_elements {

	public static void main(String[] args) {
		int[] result = product_array(new int[]{1,7,2,1,6,10,12,3});
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
	}
	
	public static int[] product_array(int[] A) {
		int size = A.length;
		int[] product_Array = new int[size];
		for (int i = 0; i < size; i++) {
			int j=i-1,k=i+1;
			product_Array[i] = 1;
			while(j>=0 || k<=size-1) {
				if(j == -1) {
					product_Array[i] = product_Array[i] * A[k];
					k++;
				}else if(k == size) {
					product_Array[i] = product_Array[i] * A[j];
					j--;
				}else {
					product_Array[i] = product_Array[i] * A[j] * A[k];
					j--;
					k++;
				}
			
			}
			
		}
		
		return product_Array;
	}

}
