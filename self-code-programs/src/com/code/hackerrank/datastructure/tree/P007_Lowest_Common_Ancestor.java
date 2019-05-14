package com.code.hackerrank.datastructure.tree;

public class P007_Lowest_Common_Ancestor {
	
	public static Node lca(Node root, int v1, int v2) {
		Node current = root;
		while(true) {
			Node n1 = getNext(current, v1);
			Node n2 = getNext(current, v2);
			
			if(n1 != n2 || current.data==v1 || current.data==v2) {
				break;
			}
			
			current = n1;
		}
		
		return current;
	}
	
	private static Node getNext(Node node, int val) {
		if(node == null) {
			return null;
		}
		
		if(val <= node.data) {
			return node.left;
		}else {
			return node.right;
		}
	}
	
}
