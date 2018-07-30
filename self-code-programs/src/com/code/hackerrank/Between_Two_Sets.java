package com.code.hackerrank;

public class Between_Two_Sets {

	public static void main(String[] args) {
		int[] a = new int[]{2,4};
		int[] b = new int[]{16,32,96};
		System.out.println(getTotalX(a,b));
	}
	
    static int getTotalX(int[] a, int[] b) {
    	int lcmA = getLCM(a);
    	int hcfB = getHCF(b);
    	int count = 0;
    	
    	for(int i=1; i*lcmA<=hcfB; i++){
    		if(hcfB%(i*lcmA)==0)count++;
    	}
    	return count;
    }
    
    static int getHCF(int a, int b){
    	int temp;
    	while(a>0){
    		temp = a;
    		a = b%a;
    		b = temp;
    	}
    	return b;
    }
    
    static int getHCF(int[] arr){
    	int lcm = arr[0];
    	for(int el : arr){
    		lcm = getHCF(lcm, el);
    	}
    	return lcm;
    }

    static int getLCM(int a, int b) {
    	return (a*b)/getHCF(a, b);
	}
    
    static int getLCM(int[] arr){
    	int hcf = arr[0];
    	for(int el : arr){
    		hcf = getLCM(hcf, el);
    	}
    	return hcf;
    }

	
    
}
