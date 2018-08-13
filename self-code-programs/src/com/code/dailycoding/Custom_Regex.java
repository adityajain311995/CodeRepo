package com.code.dailycoding;

import java.util.UUID;

/**
<pre>This problem was asked by Facebook.

Implement regular expression matching with the following special characters:
	. (period) which matches any single character
	{@literal}* (asterisk) which matches zero or more of the preceding element
That is, implement a function that takes in a string and a 
valid regular expression and returns whether or not the 
string matches the regular expression.

For example, given the regular expression "ra." and 
the string "ray", your function should return true. 
The same regular expression on the string "raymond" should return false.

Given the regular expression ".*at" and the string "chat", 
your function should return true. The same regular expression on the string 
"chats" should return false.</pre>
 */
public class Custom_Regex {

	static int r=0;
	static int s=0;
	static boolean match = false;
	public static void main(String[] args) {
		String sd = "sds|";
		for(String sr : sd.split("#")){
			System.out.println(sr);
		}
	}

	
	
	
	public static void match(String regex, String word){
		char[] reg = regex.toCharArray();
		char[] wor = word.toCharArray();
		
		while(!match){
			if(reg[r]!='.' && reg[r]!='*'){
				check(reg, wor);
			}else if(reg[r]=='.'){
				s++;
			}else if(reg[r]=='*'){
				r++;
				while(reg[r]!=wor[s]){
					s++;
					if(s>wor.length){
						break;
					}
				}
			}
		}
	}
	
	public static void check(char[] reg, char[] wor){
		if(reg[r] == wor[s]){
			r++;
			s++;
		}else{
			r=0;
			s++;
		}
	}
}
