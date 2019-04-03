package com.code.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P8_Split_the_Phone_Numbers {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        
        String regex = "^(\\d{1,3})(-| )(\\d{1,3})\\2(\\d{4,10})$";
        Pattern pattern = Pattern.compile(regex);
        
        for (int i = 0; i < N; i++) {
			String text = sc.nextLine();
			Matcher matcher = pattern.matcher(text);
			if(matcher.find()) {
				System.out.println("CountryCode="+matcher.group(1)+",LocalAreaCode="+matcher.group(3)+",Number="+matcher.group(4));
			}
		}
    }

	
}
