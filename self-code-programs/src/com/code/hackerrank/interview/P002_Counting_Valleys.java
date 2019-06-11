package com.code.hackerrank.interview;

public class P002_Counting_Valleys {

	static int countingValleys(int n, String s) {
		int level = 0;
		int valleys = 0;
		for(char move : s.toCharArray()) {
			if(move=='U') {
				level++;
			}else {
				level--;
			}
			
			if(level==0 && move=='U') {
				valleys++;
			}
		}
		return valleys;
	}

}
