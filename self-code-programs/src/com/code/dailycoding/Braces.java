package com.code.dailycoding;

import java.util.Stack;

/**
 * 
<pre>This problem was asked by Facebook.

Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false.</pre>
 *
 */
public class Braces {

	public static void main(String[] args) {
		String word1 = "([])[]({})[]";
		String word2 = "([)]";
		System.out.println(check(word1));
		System.out.println(check(word2));
	}
	
	static boolean check(String word) {
		Stack<Character> stack = new Stack<Character>();
		boolean flag = true;
		for(char curr : word.toCharArray()) {
			if(curr=='(' || curr=='[' || curr=='{') {
				stack.push(curr);
			}else if(curr==')' || curr==']' || curr=='}') {
				if(!stack.isEmpty() && curr==close_bracket(stack.peek())) {
					stack.pop();
				}else {
					flag = false;
					break;
				}
			}
		}
		
		return flag && stack.isEmpty();
	}
	
	static int close_bracket(char bracket) {
		switch (bracket) {
		case '(':
			return ')';
		case '[':
			return ']';
		case '{':
			return '}';
		default:
			return -1;
		}
	}
}
