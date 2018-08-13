package com.code.learn.random;

public class HCF_LCM {

	public static void main(String[] args) {
		int[] arr = new int[] {2,4,6,8};
		System.out.println(hcf(arr));
		System.out.println(lcm(arr));
	}
	
	public static int hcf(int a, int b) {
		while(a!=0) {
			int temp = a;
			a = b%a;
			b = temp;
		}
		return b;
	}
	
	public static int hcf(int[] arr) {
		int hcf = arr[0];
		for (int i = 1; i < arr.length; i++) {
			hcf = hcf(hcf, arr[i]);
		}
		return hcf;
	}
	
	public static int lcm(int a, int b) {
		return (a*b)/hcf(a, b);
	}
	
	public static int lcm(int[] arr) {
		int lcm = arr[0];
		for (int i = 1; i < arr.length; i++) {
			lcm = lcm(lcm, arr[i]);
		}
		return lcm;
	}
	
}
