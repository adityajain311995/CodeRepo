package com.code.hackerrank.interview;

public class P013_Alternating_Characters {

    static int alternatingCharacters(String s) {
    	char repeatingChar = 'x'; 
    	int result = 0;
    	for(char ch : s.toCharArray()) {
    		if(ch != repeatingChar) {
    			repeatingChar = ch;
    		}else {
    			result++;
    		}
    	}
    	return result;
    }
	
}
