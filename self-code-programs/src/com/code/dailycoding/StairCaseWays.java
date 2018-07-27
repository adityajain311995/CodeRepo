package com.code.dailycoding;

import java.util.HashMap;
import java.util.Map;

public class StairCaseWays {

	static final int[] steps = new int[]{1,10};
	static Map<Integer,Long> memo = new HashMap<>();
	public static void main(String[] args) {
		System.out.println(ways_memoize(100));
		
	}
	
	public static long ways_memoize(int stairs){
		if(memo.containsKey(stairs)){
			return memo.get(stairs);
		}
		
		if(stairs==0){
			return 1;
		}else if(stairs<0){
			return 0;
		}
		long total_ways = 0;
		for (int step : steps) {
			total_ways = total_ways + ways_memoize(stairs - step); 
		}
		memo.put(stairs, total_ways);
		return total_ways;
	}
	
	public static long ways_bottomUp(int stairs){
		int a=1,b=1,c;
		return 1;
	}
	
}
