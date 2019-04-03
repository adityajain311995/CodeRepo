package com.code.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/find-hackerrank/problem
 * @author adijain4
 *
 */
public class P4_Find_HackerRank {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lines = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<lines; i++) {
			String text = sc.nextLine();
			
			if(Pattern.matches("^((hackerrank)|(\\2.*\\2))$", text)) {
				System.out.println("0");
			}else if(Pattern.matches(".*hackerrank$", text)) {
				System.out.println("2");
			}else if(Pattern.matches("^hackerrank.*", text)) {
				System.out.println("1");
			}else {
				System.out.println("-1");
			}
			
		}
    }
	
}
