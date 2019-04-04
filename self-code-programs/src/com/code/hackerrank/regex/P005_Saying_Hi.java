package com.code.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/saying-hi/problem
 * @author adijain4
 *
 */
public class P005_Saying_Hi {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lines = Integer.parseInt(sc.nextLine());
		String regex = "^[Hh][Ii]\\s[^(Dd)].*";
		for(int i=0; i<lines; i++) {
			String text = sc.nextLine();
			if(Pattern.matches(regex, text)) {
				System.out.println(text);
			}
		}
    }
}
