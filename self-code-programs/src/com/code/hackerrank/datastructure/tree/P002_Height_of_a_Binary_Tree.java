package com.code.hackerrank.datastructure.tree;

public class P002_Height_of_a_Binary_Tree {

	public static int height(Node root) {
		return height_true(root)-1;
	}
	
	public static int height_true(Node root) {
		if(root == null) {
			return 0;
		}
		
		int height = 1 + Math.max(height_true(root.left), height_true(root.right));
		
		return height;
    }
	
}
