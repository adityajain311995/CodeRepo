package com.code.hackerrank.datastructure.stack;

import java.io.IOException;
import java.util.Scanner;

public class P002_Equal_Stacks {

	static int equalStacks(int[] h1, int[] h2, int[] h3) {
		for (int i = h1.length - 2; i >= 0; i--) {
			h1[i] = h1[i] + h1[i + 1];
		}
		for (int i = h2.length - 2; i >= 0; i--) {
			h2[i] = h2[i] + h2[i + 1];
		}
		for (int i = h3.length - 2; i >= 0; i--) {
			h3[i] = h3[i] + h3[i + 1];
		}

		int[] minStack = h1;
		int[] stack1 = h2;
		int[] stack2 = h3;
		if (minStack.length > h2.length) {
			minStack = h2;
			stack1 = h1;
			stack2 = h3;
		}
		if (minStack.length > h3.length) {
			minStack = h3;
			stack1 = h1;
			stack2 = h2;
		}

		int result = 0;
		for (int i = 0; i < minStack.length; i++) {
			if (contains(stack1, minStack[i]) && contains(stack2, minStack[i])) {
				result = minStack[i];
				break;
			}
		}
		return result;
	}

	static boolean contains(int[] arr, int val) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == val) {
				System.out.println("val found index : " + i);
				return true;
			}
		}
		return false;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String[] n1N2N3 = scanner.nextLine().split(" ");

		int n1 = Integer.parseInt(n1N2N3[0].trim());

		int n2 = Integer.parseInt(n1N2N3[1].trim());

		int n3 = Integer.parseInt(n1N2N3[2].trim());

		int[] h1 = new int[n1];

		String[] h1Items = scanner.nextLine().split(" ");

		for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
			int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
			h1[h1Itr] = h1Item;
		}

		int[] h2 = new int[n2];

		String[] h2Items = scanner.nextLine().split(" ");

		for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
			int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
			h2[h2Itr] = h2Item;
		}

		int[] h3 = new int[n3];

		String[] h3Items = scanner.nextLine().split(" ");

		for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
			int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
			h3[h3Itr] = h3Item;
		}

		int result = equalStacks(h1, h2, h3);

		System.out.println(String.valueOf(result));

	}

}
