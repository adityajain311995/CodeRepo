package com.code.hackerrank.datastructure.tree;

public class P005_Binary_Search_Tree_Insertion {

	
	public static Node insert_recursive(Node root,int data) {
		if(root==null) {
			return new Node(data);
		}
		
		if(data <= root.data) {
			root.left = insert_recursive(root.left, data);
		}else {
			root.right = insert_recursive(root.right, data);
		}
		
    	return root;
    }
	
	public static Node insert(Node root,int data) {
		if(root == null) {
			return new Node(data);
		}
		
		Node current = root;
		
		while(true) {
			if(data <= current.data) {
				if(current.left == null) {
					current.left = new Node(data);
					break;
				}
				current = current.left;
			}else {
				if(current.right == null) {
					current.right = new Node(data);
					break;
				}
				current = current.right;
			}
		}
		
		return root;
	}
	
	
}
