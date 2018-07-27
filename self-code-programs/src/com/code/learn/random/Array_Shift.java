package com.code.learn.random;

import java.util.Arrays;

public class Array_Shift {

	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,4,5,6};
		shift(array, -4);
		for (int el : array) {
			System.out.print(el + " ");
		}
	}

	public static void shift(int[] A, int n){
		int size = A.length;
		int index;
		int[] temp = Arrays.copyOf(A, size);
		for(int i=0; i<size; i++){
			index = (i+n)%size;
			if(index<0){
				index = index + size;
			}
			A[index] = temp[i];
		}
	}
	
}
