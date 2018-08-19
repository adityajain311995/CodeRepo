package com.code.dailycoding;

/**
 * 
 * <pre>
This problem was asked by Google.

Given an array of strictly the characters 'R', 'G', and 'B',
segregate the values of the array so that all the Rs come first,
the Gs come second, and the Bs come last. You can only swap elements of the array.

Do this in linear time and in-place.
For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'],
it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 *</pre>
 */
public class RGB {

	public static void main(String[] args) {
		char[] array = new char[] {'G', 'B', 'R', 'R', 'B', 'R', 'R', 'R', 'B', 'R', 'B', 'R', 'R' ,'G', 'R', 'G', 'G', 'B', 'R', 'R', 'B', 'R' ,'R', 'B', 'R' ,'G', 'R', 'G', 'G', 'B', 'G', 'B', 'R', 'R', 'B', 'R', 'G', 'R', 'R', 'G'};
		//char[] array = new char[] {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
		for (char c : array) {
			System.out.print(c+" ");
		}
		RGB rgb = new RGB();
		rgb.sort(array);
		System.out.println("\n\nAfter Sorting...");
		for (char c : array) {
			System.out.print(c+" ");
		}
	}

	int x;
	int y;
	
	public void sort(char[] array) {
		int size = array.length;
		
		x=0;
		y=size-1;
		
		for (int i = 0; (i < array.length) && (i<=y); i++) {
			
			if(i<x) {
				i=x;
				System.out.println("i Update to x");
				continue;
			}
			
			for (int j = 0; j < 2; j++) {
				if (array[i] == 'G') {
					continue;
				} else if (array[i] == 'R') {
					updateR(array, i);
				} else if (array[i] == 'B') {
					updateB(array, i);
				} 
			}
		}
		
	}
	
	private void updateR(char[] array, int i) {
		while(array[x]=='R') {
			x++;
		}
		if(array[i]!='R' || i<x) {
			return;
		}
		swap(array, x, i);
		x++;
	}
	
	private void updateB(char[] array, int i) {
		while(array[y]=='B') {
			y--;
		}
		if(array[i]!='B' || i>y) {
			return;
		}
		swap(array, i, y);
		y--;
	}

	private void swap(char[] array, int m, int n) {
		if(m==n) {return;}
		char temp = array[m];
		array[m] = array[n];
		array[n] = temp;
	}
	
}
