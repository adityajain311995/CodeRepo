package com.code.hackerrank.datastructure.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class P002_2d_Hour_Glass_Sum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int maxVal = -64;
    	int rows = arr.length;
    	int cols = arr[0].length;
    	
    	if(rows <3 || cols <3) {
    		return 0;
    	}
    	
    	for(int i=0; i<=rows-3; i++) {
    		for(int j=0; j<=cols-3; j++) {
    			int sum = 0;
    			sum = sum + arr[i][j] + arr[i][j+1] + arr[i][j+2];
    			sum = sum +            arr[i+1][j+1];
    			sum = sum + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
    			
    			if(sum > maxVal) {
    				maxVal = sum;
    			}
    		}
    	}
    	
    	return maxVal;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
	
}
