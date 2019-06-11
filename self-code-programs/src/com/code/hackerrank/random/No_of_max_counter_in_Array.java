package com.code.hackerrank.random;

public class No_of_max_counter_in_Array {

	public static void main(String[] args) {
		//Ans is 5 (five 9s)
		System.out.println(maxCounter(new int[]{9,4,9,7,1,5,9,9,1,2,9}));
	}

	static int maxCounter(int[] ar) {
		int max = 0;
		int counter = 0;
		for (int el : ar) {
			if (max < el) {
				max = el;
				counter = 1;
			} else if (max == el) {
				counter++;
			}
		}
		return counter;

	}

}
