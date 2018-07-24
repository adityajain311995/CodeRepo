package com.code.datastructure.trees;

import java.util.Stack;

public class OrderTraversal_Iterative_Stack {

	public static void main(String[] args) {
		Tree_Node node = Tree_Node.getSampleTree1();
		preOrder(node);
	}
	
	public static void preOrder(Tree_Node root){
		Stack<Tree_Node> stack = new Stack<Tree_Node>();
		stack.push(root);
		Tree_Node node;
		while(!stack.isEmpty()){
			node = stack.pop();
			System.out.print(node.getData() + " ");
			
			if(node.getRight()!=null)stack.push(node.getRight());
			if(node.getLeft()!=null)stack.push(node.getLeft());
		}
		
	}	
	
}
