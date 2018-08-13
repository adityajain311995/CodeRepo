package com.code.hackerrank;

import java.util.List;

/**
 * 
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem?h_r=next-challenge&h_v=zen
 *
 */
public class Birthday_Chocolate {

	public static void main(String[] args) {
	}

    static int birthday(List<Integer> s, int d, int m) {
    	int result = 0;
    	int sum;
    	for (int i = m-1; i < s.size(); i++) {
			sum = 0;
    		for(int j=0; j<m; j++){
				sum += s.get(i-j);
			}
    		if(sum==d)result++;
		}
    	return result;
    }
}
