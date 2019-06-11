package com.code.hackerrank.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class P001_Sock_Merchant {

	public static void main(String[] args) {
		int[] ar = {10,20,20,10,10,30,50,10,20};
		sockMerchant(9, ar);
	}
	
	static int sockMerchant(int n, int[] ar) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < ar.length; i++) {
			if(map.containsKey(ar[i])) {
				map.put(ar[i], map.get(ar[i]) + 1);
				continue;
			}
			map.put(ar[i], 1);
		}
		int total = 0;
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			total += entry.getValue()/2;
		}
		return total;
    }
	
}
