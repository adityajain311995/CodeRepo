package com.code.hackerrank.problemsolving;

public class P001_Drawing_Book {

	static int pageCount(int n, int p) {
		return Math.min(fromFront(n, p), fromBack(n, p));
	}
	
	static private int fromBack(int n, int p) {
		if(n%2!=0) {
			n = n-1;
		}
		int a = n-p+1;
		return a/2;
	}
	
	static private int fromFront(int n, int p) {
		return p/2;
	}

}
