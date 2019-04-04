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
public class P012_UK_and_US_Part_2 {

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
            String word2 = word.replaceFirst("our", "or");
            String regex = "(\\b" + word + "\\b)" + "|" + "(\\b" + word2 + "\\b)";
            Matcher matcher = Pattern.compile(regex).matcher(sw.toString());
            int count = 0;
            while(matcher.find()) {
                count++;
            }
            System.out.println(count);
        }
        sc.close();
    }
	
}
