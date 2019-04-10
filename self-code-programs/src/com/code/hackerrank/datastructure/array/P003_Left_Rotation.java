package com.code.hackerrank.datastructure.array;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/array-left-rotation/problem
 * 
 * @author adijain4
 *
 */
public class P003_Left_Rotation {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] nd = scanner.nextLine().split(" ");
		int n = Integer.parseInt(nd[0]);
		int d = Integer.parseInt(nd[1]);
		int[] a = new int[n];
		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}
		shift(a, d);

		String output = "";
		for (int i = 0; i < a.length; i++) {
			output = output + a[i] + " ";
		}
		System.out.println(output.trim());
		scanner.close();
	}

	static void shift(int[] arr, int times) {
		if (times == 0) {
			return;
		}
		int size = arr.length;
		times = times % size;
		if (size - times < times) {
			right(arr, size - times, size);
		} else {
			left(arr, times, size);
		}

	}

	private static void left(int[] arr, int times, int size) {
		int[] temp = new int[times];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = arr[i];
		}

		for (int i = 0; i < size - times; i++) {
			arr[i] = arr[i + times];
		}
		for (int i = size - times, j = 0; i < size; i++, j++) {
			arr[i] = temp[j];
		}
	}

	private static void right(int[] arr, int times, int size) {
		int[] temp = new int[times];
		for (int i = 0; i < times; i++) {
			temp[i] = arr[size-times + i];
		}

		for(int i=size-1; i>=times; i--) {
			arr[i] = arr[i-times];
		}
		
		for(int i=0; i<times; i++) {
			arr[i] = temp[i];
		}
	}

}
