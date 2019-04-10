package com.code.hackerrank.datastructure.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays/problem
 * 
 * @author adijain4
 *
 */
public class P005_Sparse_Array {
	// Complete the matchingStrings function below.
	static int[] matchingStrings(String[] strings, String[] queries) {
		Map<String, Integer> map = new HashMap<>();
		for(String string : strings) {
			if(map.containsKey(string)) {
				map.put(string, map.get(string) + 1);
			}else {
				map.put(string, 1);
			}
		}
		int[] result = new int[queries.length];
		for(int i=0; i<queries.length; i++) {
			if(map.containsKey(queries[i])) {
				result[i] = map.get(queries[i]);
			}else {
				result[i] = 0;
			}
		}
		
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int stringsCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] strings = new String[stringsCount];

		for (int i = 0; i < stringsCount; i++) {
			String stringsItem = scanner.nextLine();
			strings[i] = stringsItem;
		}
		int queriesCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] queries = new String[queriesCount];
		for (int i = 0; i < queriesCount; i++) {
			String queriesItem = scanner.nextLine();
			queries[i] = queriesItem;
		}

		int[] res = matchingStrings(strings, queries);
		for (int i = 0; i < res.length; i++) {
			bufferedWriter.write(String.valueOf(res[i]));

			if (i != res.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();
		bufferedWriter.close();
		scanner.close();
	}
}
