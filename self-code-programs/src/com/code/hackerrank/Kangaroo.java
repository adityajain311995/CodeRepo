package com.code.hackerrank;

/**
 * https://www.hackerrank.com/challenges/kangaroo/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */
public class Kangaroo {

	public static void main(String[] args) {

	}

    static String kangaroo(int x1, int v1, int x2, int v2) {
    	int relativeV = v1 - v2;
    	int distance = x2 - x1;
    	
    	if(relativeV >0 && distance%relativeV == 0)return "YES";
    	
    	return "NO";
    }
	
}
