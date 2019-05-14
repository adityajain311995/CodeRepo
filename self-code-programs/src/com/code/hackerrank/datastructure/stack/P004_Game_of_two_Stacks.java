package com.code.hackerrank.datastructure.stack;
/**
 * 
 * Incomplete........................
 *
 */
public class P004_Game_of_two_Stacks {

    static int twoStacks(int x, int[] a, int[] b) {
    	int ai = 0;
    	int bi = 0;
    	
    	int[] aSum = new int[a.length];
    	int[] bSum = new int[b.length];
    	
    	for (int i = 1; i < a.length; i++) {
    		aSum[i] = a[i-1] + a[i];
		}
    	for (int i = 1; i < b.length; i++) {
			bSum[i] = b[i-1] + b[i];
		}
    	
    	
    	while(ai < aSum.length-1 && aSum[ai+1] < x) {
    		ai++;
    	}
    	while(bi < bSum.length-1 && bSum[bi+1] < x) {
    		bi++;
    	}
    	
    	int sum = a[ai] + b[bi];
    	
    	while(sum > x) {
    		System.out.println("here");
    		if(a[ai]/ai  > b[bi]/bi) {
    			ai--;
    		}else if(a[ai]/ai  < b[bi]/bi) {
    			bi--;
    		}
    		sum = a[ai] + b[bi];
    	}
    	System.out.println("ai = "+ai);
    	System.out.println("bi = "+bi);
    	return ai+bi+2;
    }    	
	
}
