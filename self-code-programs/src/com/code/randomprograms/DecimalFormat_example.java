package com.code.randomprograms;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DecimalFormat_example {
	
	static DecimalFormat formatter = new DecimalFormat("0.00");
	
	public static void main(String[] args) {
		Double value1 = 12345.1251;
		Double value2 = 12345.1200;
		Double value3 = 12345.1000;
		Double value4 = 0.1254;
		Double value5 = 0.00;
		Double value6 = 0.0;
		Double value7 = 12.0;
		formatter.setRoundingMode(RoundingMode.HALF_DOWN);
		System.out.println("value1-->" + value1 + " || " + formatter.format(value1));
		System.out.println("\nvalue2-->" + value2 + " || " + formatter.format(value2));
		System.out.println("\nvalue3-->" + value3 + " || " + formatter.format(value3));
		System.out.println("\nvalue4-->" + value4 + " || " + formatter.format(value4));
		System.out.println("\nvalue5-->" + value5 + " || " + formatter.format(value5));
		System.out.println("\nvalue6-->" + value6 + " || " + formatter.format(value6));
		System.out.println("\nvalue7-->" + value7 + " || " + formatter.format(value7));
	}
}
