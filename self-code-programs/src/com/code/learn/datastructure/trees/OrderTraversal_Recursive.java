package com.code.learn.datastructure.trees;

public class OrderTraversal_Recursive {

	public static void main(String[] args) {
		Tree_Node node = Tree_Node.getSampleTree1();
		preOrder(node);
	}
	
	public static void preOrder(Tree_Node root){
		if(root == null){
			return;
		}
		System.out.print(root.getData() + " ");
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}

}
