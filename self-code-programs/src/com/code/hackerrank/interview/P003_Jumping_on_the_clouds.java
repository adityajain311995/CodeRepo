package com.code.hackerrank.interview;

public class P003_Jumping_on_the_clouds {

	static int jumpingOnClouds(int[] c) {
		int jumps = 0;
		int i = 0;
		while(i<c.length) {
			if(i+2<c.length && c[i+2]!=1) {
				i = i+2;
			}else {
				i = i+1;
			}
			jumps++;
		}
		if(i>=c.length) {
			jumps--;
		}
		
		return jumps;
	}

}
