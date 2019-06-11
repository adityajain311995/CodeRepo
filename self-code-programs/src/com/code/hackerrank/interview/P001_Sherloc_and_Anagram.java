package com.code.hackerrank.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class P001_Sherloc_and_Anagram {
	public static void main(String[] args) {
		sherlockAndAnagrams("kkkk");
	}

	static int sherlockAndAnagrams(String s) {
		char[] string = s.toCharArray();
		Map<String,Integer> map = new HashMap<>();
		int count = 0;
		for (int window = 1; window < s.length(); window++) {
			for (int i = 0; i <= s.length() - window; i++) {
				String s1 = s.substring(i, i+window);
				String sorted = getSorted(s1);
				if(map.containsKey(sorted)) {
					map.put(sorted, map.get(sorted) + 1);
				}else {
					map.put(sorted, 1);
				}
			}
		}
		
		for(Entry<String, Integer> entry : map.entrySet()) {
			count += getPairCount(entry.getValue());
		}
		
		System.out.println(count);
		return count;
	}

	static String getSorted(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		System.out.println("|" + new String(charArray) + "|");
		return new String(charArray);
	}
	
	static int getPairCount(Integer n) {
		int count = (n*(n-1))/2;
		return count;
	}
}
