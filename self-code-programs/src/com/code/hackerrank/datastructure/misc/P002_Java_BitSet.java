package com.code.hackerrank.datastructure.misc;

import java.util.BitSet;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-bitset/problem
 * @author adijain4
 *
 */
public class P002_Java_BitSet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		BitSet s1 = new BitSet(N);
		BitSet s2 = new BitSet(N);
		sc.nextLine();
		for(int i=0; i<M; i++) {
			String[] vars = sc.nextLine().split(" ");
			operate(vars[0], Integer.parseInt(vars[1]), Integer.parseInt(vars[2]), s1, s2);
			System.out.println(s1.cardinality() + " " + s2.cardinality());
		}
	}

	private static void operate(String operation, int var1, int var2, BitSet s1, BitSet s2) {
		if("AND".equals(operation)) {
			if(var1 == 1) {
				s1.and(s2);
			}else {
				s2.and(s1);
			}
		}
		
		if("OR".equals(operation)) {
			if(var1 == 1) {
				s1.or(s2);
			}else {
				s2.or(s1);
			}
		}

		if("XOR".equals(operation)) {
			if(var1 == 1) {
				s1.xor(s2);
			}else {
				s2.xor(s1);
			}
		}

		if("FLIP".equals(operation)) {
			if(var1 == 1) {
				s1.flip(var2);
			}else {
				s2.flip(var2);
			}
		}

		if("SET".equals(operation)) {
			if(var1 == 1) {
				s1.set(var2);
			}else {
				s2.set(var2);
			}
		}
	}
}
