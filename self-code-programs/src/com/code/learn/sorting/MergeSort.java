package com.code.learn.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[] {3,1,5,4,6,7,2,9,10,51,20,14,99};
		mergeSort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	
	public static void mergeSort(int[] arr, int begin, int end) {
		if(begin<end) {
			int mid = (begin+end)/2;
			
			mergeSort(arr, begin, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, begin, mid, end);
		}
	}
	
	private static void merge(int[] arr, int begin, int mid, int end) {
		int s1 = mid-begin+1;
		int s2 = end-mid;
		
		int[] A = new int[s1];
		int[] B = new int[s2];
		
		for(int i=0;i<s1;i++)A[i]=arr[begin+i]; //Copy arr1 element to A
		for(int i=0;i<s2;i++)B[i]=arr[mid+1+i]; //Copy arr2 element to B
		
		int i = 0;
		int j = 0;
		int k = begin;
		
		//Compare and put
		while(i<s1 && j<s2) {
			if(A[i] <= B[j]) {
				arr[k] = A[i];
				i++;
			}else {
				arr[k] = B[j];
				j++;
			}
			k++;
		}
		
		//Put remaining elements
		while(i<s1) {
			arr[k] = A[i];
			i++;
			k++;
		}
		
		while(j<s2) {
			arr[k] = B[j];
			j++;
			k++;
		}
		
	}
	
}
