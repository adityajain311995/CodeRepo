package com.code.hackerrank.random;
/**
 * 
 * https://www.hackerrank.com/challenges/divisible-sum-pairs/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 *
 */
public class Divisible_Sum_Pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    static int divisibleSumPairs(int k, int[] ar) {
    	int sum;
    	int count = 0;
    	for (int i = 0; i < ar.length-1; i++) {
    		for (int j = i+1; j < ar.length; j++) {
				if((ar[i] + ar[j])%k==0)count++;
			}
		}
    	return count;
    }
	
}
