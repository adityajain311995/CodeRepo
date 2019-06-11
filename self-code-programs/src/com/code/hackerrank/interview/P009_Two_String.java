package com.code.hackerrank.interview;

import java.util.ArrayList;
import java.util.List;

public class P009_Two_String {

    static String twoStrings(String s1, String s2) {
    	List<Character> list = new ArrayList<>();
    	for (int i = 0; i < s1.length(); i++) {
			if(!list.contains(s1.charAt(i))) {
				list.add(s1.charAt(i));
			}
		}
    	
    	for (int i = 0; i < s2.length(); i++) {
    		if(list.contains(s2.charAt(i))) {
    			return "YES";
    		}
    	}
    	return "NO";
    }
	
}
