package com.code.hackerrank.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class P012_Strings_Making_Anagram {

    static int makeAnagram(String a, String b) {
    	Map<String,Integer> mapA = new HashMap<>();
    	Map<String,Integer> mapB = new HashMap<>();
    	int number = 0;
    	for(char ch : a.toCharArray()) {
    		addToMap(mapA, String.valueOf(ch));
    	}
    	for(char ch : b.toCharArray()) {
    		if(mapA.containsKey(String.valueOf(ch))) {
    			removeFromMap(mapA, String.valueOf(ch));
    		}else {
    			addToMap(mapB, String.valueOf(ch));
    		}
    	}
    	
    	for(Entry<String, Integer> entry : mapA.entrySet()) {
    		number += entry.getValue();
    	}
    	for(Entry<String, Integer> entry : mapB.entrySet()) {
    		number += entry.getValue();
    	}
    	return number;
    }

	static void addToMap(Map<String, Integer> map, String key) {
		if (map.containsKey(key)) {
			map.put(key, map.get(key) + 1);
		} else {
			map.put(key, 1);
		}
	}
	
	static void removeFromMap(Map<String, Integer> map, String key) {
		if (map.containsKey(key)) {
			int value = map.get(key) - 1;
			map.put(key, value);
			if(value==0) {
				map.remove(key);
			}
		}
	}
	
}
