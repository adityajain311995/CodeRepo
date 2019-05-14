package com.code.hackerrank.datastructure.stack;

import java.util.Stack;

public class P003_Balanced_Brackets {

	static String isBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		for(char bracket : s.toCharArray()) {
			if(bracket == '(' || bracket == '{' || bracket == '[') {
				stack.push(bracket);
			}else {
				if(stack.isEmpty() || stack.pop().charValue() != getOpenBracket(bracket)) {
					return "NO";
				}
			}
		}
		
		if(!stack.isEmpty()) {
			return "NO";
		}
		
		return "YES";
	}
	
	static char getOpenBracket(char close) {
		char open;
		if(close == ')') {
			open = '(';
		}else if(close == '}') {
			open = '{';
		}else {
			open = '[';
		}
		return open;
		
	}

}
