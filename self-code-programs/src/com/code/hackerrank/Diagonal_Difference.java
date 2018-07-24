package com.code.hackerrank;

public class Diagonal_Difference {

    static int diagonalDifference(int[][] arr, int size) {
        int sumD1 = 0;
        int sumD2 = 0;
        for(int i=0,j=0,k=size-1; i<size && j<size && k>=0; i++,j++,k--){
            sumD1 += arr[i][j];
            sumD2 += arr[i][k];
        }
        return Math.abs(sumD1-sumD2);
    }
	
}
