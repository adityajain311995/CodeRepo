package com.code.hackerrank;

public class Staircase {

	public static void main(String[] args) {
		staircase(10);

	}
	
    static void staircase(int n) {
    	int j;
        for(int i=1; i<=n; i++){
        	for(j=0; j<n-i; j++){
        		System.out.print(" ");
        	}
        	for(j=0; j<i; j++){
        		System.out.print("#");
        	}
        	System.out.println("");
        }
    }

}
