package com.code.hackerrank.regex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/detect-the-email-addresses/problem
 * 
 * @author adijain4
 *
 */
public class P2_Detect_the_Email_address {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lines = Integer.parseInt(sc.nextLine());
		
		List<String> emails = new ArrayList<>();
		for(int i=0; i<lines; i++) {
			String text = sc.nextLine();
			Pattern pattern = Pattern.compile("\\S+@\\S*\\.[a-zA-Z]+");
			Matcher matcher = pattern.matcher(text);
			while(matcher.find()) {
				String group = matcher.group();
				if(!emails.contains(group)) {
					emails.add(group);
				}
			}
		}
		
		emails.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int res = o1.compareTo(o2);
				int ret;
				if(res>0) {
					ret=1;
				}else if(res<0) {
					ret=-1;
				}else {
					ret=0;
				}
				
				return ret;
			}
		});
		
		String output = String.join(";", emails);
		
		
		System.out.println(output);
	}
}