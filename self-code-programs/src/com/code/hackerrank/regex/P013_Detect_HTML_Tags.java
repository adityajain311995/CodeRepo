package com.code.hackerrank.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/detect-html-tags/problem
 * 
 * @author adijain4
 *
 */
public class P013_Detect_HTML_Tags {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine());

		StringWriter sw = new StringWriter();
		IntStream.range(0, n).forEach(i -> {
			try {
				sw.append(br.readLine());
			} catch (IOException e) {
			}
		});

		String input = sw.toString();
		Pattern pattern = Pattern.compile("(?<=</? {0,9})[a-zA-Z0-1]+");
		Matcher matcher = pattern.matcher(input);
		Set<String> set = new TreeSet<>();
		while (matcher.find()) {
			set.add(matcher.group());
		}

		System.out.println(String.join(";", set));

		br.close();
		sw.close();

	}

}
