package com.code.hackerrank.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class P006_New_Year_Chaos {

	static void minimumBribes(int[] q) {
		for (int i = 0; i < q.length; i++) {
			if(q[i]-i-1 > 2) {
				System.out.println("Too chaotic");
				return;
			}
		}
		int maxSwap = q.length * 2;
		int swapCount = 0;
		int traverseLenth = 0;
		
		int i = 0;
		while (true) {
			if(i==0) {
				traverseLenth = 0;
			}
			if (i+1 < q.length && q[i + 1] < q[i]) {
				swap(q, i, i + 1);
				swapCount++;
			}else {
				traverseLenth++;
			}
			
			if(swapCount>maxSwap) {
				System.out.println("Too chaotic");
				break;
			}else if(traverseLenth==q.length) {
				System.out.println(swapCount);
				break;
			}
			i = (i + 1) % q.length;
		}

	}

	private static void swap(int[] q, int i, int j) {
		int temp = q[i];
		q[i] = q[j];
		q[j] = temp;
	}

}
