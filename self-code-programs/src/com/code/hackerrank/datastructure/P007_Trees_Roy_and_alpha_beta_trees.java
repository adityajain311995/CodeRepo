package com.code.hackerrank.datastructure;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/roy-and-alpha-beta-trees/problem
 * 
 * (sum of numbers on even levels * alpha) - (sum of numbers on odd levels * beta)
 * @author adijain4
 *
 */
public class P007_Trees_Roy_and_alpha_beta_trees {

	
	public static void main(String[] args) {
		int alpha = 1;
		int beta = 1;
		int[] arr = {1,2,3,4,5};
		System.out.println(solve(alpha, beta, arr));
	}
	
    static int solve(int alpha, int beta, int[] arr) {
    	Arrays.sort(arr);
    	
    	for (int i=0; i<arr.length ; i++) {
    		int sum = tree(i, arr);
    	}
    	
    	return 0;
    }

	private static int tree(int i, int[] arr) {
		
//		int sum = nodeSum(0, i, arr, false);
//		int sum2 = nodeSum(i+1, arr.length, arr, false);
		return 0;
	}

	private static int nodeSum(int node, int currElem, boolean isEven) {
		
		if(isEven) {
			if(currElem<=node) {
				
			}else {
				
			}
		}
		
		
		return 0;
	}
	
}
