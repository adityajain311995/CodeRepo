package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P001_Increff_Number_of_pie {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < T; i++) {
			String[] line = sc.nextLine().split(" ");
			int N = Integer.parseInt(sc.nextLine());
			int noOfPies = Integer.parseInt(line[0]);
			int[] array = new int[noOfPies];
			for (int j = 0; j < noOfPies; j++) {
				array[j] = Integer.parseInt(line[j+1]);
			}
			if(isSum(array, noOfPies, N)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

	static boolean isSum(int[] array, int n, int sum) {
		if (sum == 0) {
			return true;
		}
		if (n == 0 && sum != 0) {
			return false;
		}
		if (array[n - 1] > sum) {
			return isSum(array, n - 1, sum);
		}
		return isSum(array, n - 1, sum) || isSum(array, n - 1, sum - array[n - 1]);
	}

}
