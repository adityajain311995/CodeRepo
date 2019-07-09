package com.interview;

import java.util.HashSet;
import java.util.Set;

public class P004_Goldman_Sach_1_Non_Repeating_digit_in_product {

	public static void main(String[] args) {
		//nonRepeatingDigitProductCount(0,25,40);
		System.out.println(getDigitsSet(0));
	}

	static int nonRepeatingDigitProductCount(int x, int y, int z) {
		int count = 0;
		boolean valid = true;
		for (int N = y; N <= z; N++) {
			valid = true;
			Set<Integer> setN = getDigitsSet(N);
			System.out.println(String.valueOf(N) + " " + (Long.valueOf(N) * Long.valueOf(x)));
			Set<Integer> setProduct = getDigitsSet(Long.valueOf(N) * Long.valueOf(x));

			for (int digit : setN) {
				if (setProduct.contains(digit)) {
					valid = false;
					break;
				}
			}
			if (valid) {
				count++;
			}
		}
		return count;
	}

	static Set<Integer> getDigitsSet(long number) {
		number = number>0 ? number : -number;
		Set<Integer> set = new HashSet<>();
		if(number == 0L) {
			set.add(0);
		}
		while (number != 0) {
			set.add(Long.valueOf(number % 10).intValue());
			number = number / 10;
		}
		return set;
	}

}
