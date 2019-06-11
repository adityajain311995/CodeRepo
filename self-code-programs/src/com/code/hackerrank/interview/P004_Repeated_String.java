package com.code.hackerrank.interview;

public class P004_Repeated_String {

	static long repeatedString(String s, long n) {
		long length = s.length();
		long number = n / length;
		long offset = n % length;

		long count = 0;
		long offsetCount = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				count++;
				if (offset != 0 && i < offset) {
					offsetCount++;
				}
			}
		}
		return count*number + offsetCount;
	}

}
