package com.code.hackerrank.regex;

import java.io.StringWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/uk-and-us/problem
 * @author adijain4
 *
 */
public class P010_The_British_and_American_Style_of_Spelling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		StringWriter sw = new StringWriter();
		
		for(int i=0; i<N; i++) {
			sw.append(sc.nextLine()).append(" ");
		}
		
		int T = Integer.parseInt(sc.nextLine());
		for(int i=0; i<T; i++) {
			String word = sc.nextLine();
			String word2 = word.replaceFirst("ze$", "se");
			String regex = "(" + word + ")" + "|" + "(" + word2 + ")";
			Matcher matcher = Pattern.compile(regex).matcher(sw.toString());
			int count = 0;
			while(matcher.find()) {
				count++;
			}
			System.out.println(count);
		}
    }
	
}
