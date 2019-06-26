package com.code.hackerrank.interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P014_Sherlock_and_the_Valid_String {
	
	public static void main(String[] args) {
		System.out.println(isValid("aabbc"));
	}
	
	static String isValid(String s) {
    	Map<String,Integer> map = new HashMap<>();
		for(char ch : s.toCharArray()) {
    		addToMap(map, String.valueOf(ch));
    	}
		List<Integer> values = map.values().stream().sorted().collect(Collectors.toList());
		
		
		Map<Integer,Integer> map2 = new HashMap<>();
		for(Integer val : values) {
    		addToMap(map2, val);
    	}
		
		if(map2.size() > 2) {
			return "NO";
		}
		
		if(map2.size() == 0 || map2.size() ==1) {
			return "YES";
		}
		
		if(map2.containsKey(1)) {
			if(map2.get(1) > 1) {
				return "NO";
			}else if(map2.get(1) == 1){
				return "YES";
			}
		}else {
			List<Integer> collect = map2.keySet().stream().collect(Collectors.toList());
			int i1 = collect.get(0);
			int i2 = collect.get(1);
			int grtValue = Math.max(i1, i2);
			int minValue = Math.min(i1, i2);
			if(map2.get(grtValue) > 1) {
				return "NO";
			}else {
				if(grtValue-minValue == 1) {
					return "YES";
				}else {
					return "NO";
				}
			}
		}
		
		return "YES";
	}
	
	static <T> void addToMap(Map<T, Integer> map, T key) {
		if (map.containsKey(key)) {
			map.put(key, map.get(key) + 1);
		} else {
			map.put(key, 1);
		}
	}
}
