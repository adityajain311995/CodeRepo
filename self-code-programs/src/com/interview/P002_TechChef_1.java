package com.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P002_TechChef_1 {

	public static List<String> processStrings(String str1, String str2) {
		Set<Character> set1 = new HashSet<>();
		for (char ch : str1.toCharArray()) {
			set1.add(ch);
		}
		Set<Character> set2 = new HashSet<>();
		for (char ch : str2.toCharArray()) {
			set2.add(ch);
		}
		
		StringBuilder builder = new StringBuilder();
		Set<Character> appeared = new HashSet<>();
		for(char ch : str1.toCharArray()) {
			if(!set2.contains(ch) && !appeared.contains(ch)) {
				builder.append(ch);
				appeared.add(ch);
			}
		}
		String op1 = builder.toString();
		
		appeared.clear();
		builder = new StringBuilder();
		for (char ch : str2.toCharArray()) {
			if(!set1.contains(ch) && !appeared.contains(ch)) {
				builder.append(ch);
				appeared.add(ch);
			}
		}
		String op2 = builder.toString();
		
		List<String> result = new ArrayList<>();
		result.add(op1);
		result.add(op2);
		return result;
	}

}
