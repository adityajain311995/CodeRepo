package com.code.hackerrank.interview;

import java.util.HashMap;
import java.util.Map;

public class P008_Ransom_Note {

    static void checkMagazine(String[] magazine, String[] note) {
    	Map<String,Integer> map = new HashMap<>();
    	for (int i = 0; i < magazine.length; i++) {
			addMap(map, magazine[i]);
		}
    	
    	for (int i = 0; i < note.length; i++) {
			if(map.containsKey(note[i])) {
				removeMap(map, note[i]);
			}else {
				System.out.println("No");
				return;
			}
		}
    	System.out.println("Yes");

    }

	private static void removeMap(Map<String, Integer> map, String key) {
		if(map.containsKey(key)) {
			int value = map.get(key)-1;
			map.put(key, value);
			if(value==0) {
				map.remove(key);
			}
		}
	}

	private static void addMap(Map<String, Integer> map, String key) {
		if(map.containsKey(key)) {
			map.put(key, map.get(key)+1);
		}else {
			map.put(key, 1);
		}
	}
	
}
