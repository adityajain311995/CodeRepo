package com.code.hackerrank;

/**
 * 
 * {@link}https://www.hackerrank.com/challenges/apple-and-orange/problem?h_r=next-challenge&h_v=zen
 *
 */
public class Apple_and_Orange {

	public static void main(String[] args) {

	}

	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
		int appleCount = 0;
		int orangeCount = 0;
		for (int apple : apples) {
			if(a+apple >=s && a+apple <=t) {
				appleCount++;
			}
		}
		
		for (int orange : oranges) {
			if(b+orange >=s && b+orange <=t) {
				orangeCount++;
			}
		}
		
		System.out.println(appleCount);
		System.out.println(orangeCount);
	}

}
