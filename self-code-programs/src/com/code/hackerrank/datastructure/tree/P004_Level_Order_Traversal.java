package com.code.hackerrank.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class P004_Level_Order_Traversal {

	public static void levelOrder(Node root) {
	 if(root == null) {
		 return;
	 }
	      
	 Queue<Node> que = new LinkedList<>();
	 que.add(root);
	 
	 while(!que.isEmpty()) {
		 Node current = que.remove();
		 System.out.print(current.data + " ");
		 
		 if(current.left!=null) {
			 que.add(current.left);
		 }
		 if(current.right!=null) {
			 que.add(current.right);
		 }
	 }
    }
	
}
