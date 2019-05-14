package com.code.learn.random;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

	public static void main(String[] args) {
		int N = 100;
		List<Integer> list = getPrimeNoList(N);
		System.out.println(list);
		
	}

	private static List<Integer> getPrimeNoList(int N) {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		int i = 3;
		boolean isprime = true;
		while(list.size()<N) {
			isprime = true;
			for(int j=0; j<list.size() && list.get(j)<i; j++) {
				if(i%list.get(j)==0) {
					isprime = false;
					break;
				}
			}
			if(isprime) {
				list.add(i);
			}
			i++;
		}
		return list;
	}
	
}
