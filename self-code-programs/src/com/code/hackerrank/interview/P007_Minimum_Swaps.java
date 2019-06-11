package com.code.hackerrank.interview;

public class P007_Minimum_Swaps {

    static int minimumSwaps(int[] arr) {
    	int i = 0;
    	int doneCount = 0;
    	int swapCount = 0;
    	while(true) {
    		if(i==0) {
    			doneCount=0;
    		}
    		
    		if(i+1 != arr[i]) {
    			swap(arr,i,arr[i]-1);
    			swapCount++;
    		}else {
    			doneCount++;
    		}
    		if(doneCount==arr.length) {
    			return swapCount;
    		}
    		i = (i+1)%arr.length;
    	}
    }
	
	private static void swap(int[] q, int i, int j) {
		int temp = q[i];
		q[i] = q[j];
		q[j] = temp;
	}
}
