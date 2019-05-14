package com.code.hackerrank.datastructure.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P001_Maximum_Element {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.nextLine());
		Stack stack = new Stack();
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			char query = line.charAt(0);
			if (query == '1') {
				int val = Integer.parseInt(line.substring(2));
				stack.push(val);
			} else if (query == '2') {
				stack.pop();
			} else {
				stack.maxPrint();
			}

		}
	}

}

class Stack {

	private List<Integer> list;
	private Integer max = null;

	public Stack() {
		list = new ArrayList<Integer>();
	}

	public void push(Integer val) {
		list.add(val);

		if (max == null || max < val) {
			max = val;
		}
	}

	public void pop() {
		if (list.isEmpty()) {
			return;
		}
		int size = list.size();
		int val = list.remove(size - 1);

		if (list.isEmpty()) {
			max = null;
		}

		if (max != null && val == max) {
			max = Collections.max(list);
		}
	}

	public void maxPrint() {
		System.out.println(max);
	}

}