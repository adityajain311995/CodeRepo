package com.code.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/valid-pan-format/problem
 * 
 * @author adijain4
 *
 */
public class P011_Valid_PAN_Format {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        
        String regex = "^[A-Z]{5}\\d{4}[A-Z]$";
        
        for (int i = 0; i < N; i++) {
			String text = sc.nextLine();
			if(Pattern.matches(regex, text)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
        sc.close();
	}
}
