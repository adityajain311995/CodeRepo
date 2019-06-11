package com.code.hackerrank.interview;

public class P005_Left_Rotation {

    static int[] rotLeft(int[] a, int d) {
    	int[] rotated = new int[a.length];
    	
    	
    	for (int i = 0; i < rotated.length; i++) {
			rotated[i] = a[(i+d)%a.length];
		}
    	
    	return rotated;
    }
	
}
