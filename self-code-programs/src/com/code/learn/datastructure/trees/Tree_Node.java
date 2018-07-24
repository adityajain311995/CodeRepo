package com.code.learn.datastructure.trees;

public class Tree_Node {

	private String data;
	private Tree_Node left;
	private Tree_Node right;

	public Tree_Node(String data) {
		this.data = data;
	}

	public Tree_Node(String data, Tree_Node left, Tree_Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	
	/**
	 * Deepest Depth = 2
	 * 
	 * 			1
	 * 		  /   \ 
	 * 		 2	   3
	 *     /  \   /  \
	 *    4    5 6    7
	 */
	public static Tree_Node getSampleTree1() {
		Tree_Node root = new Tree_Node("1");
		Tree_Node node2 = new Tree_Node("2");
		Tree_Node node3 = new Tree_Node("3");
		Tree_Node node4 = new Tree_Node("4");
		Tree_Node node5 = new Tree_Node("5");
		Tree_Node node6 = new Tree_Node("6");
		Tree_Node node7 = new Tree_Node("7");

		root.setLeft(node2);
		root.setRight(node3);

		node2.setLeft(node4);
		node2.setRight(node5);

		node3.setLeft(node6);
		node3.setRight(node7);

		return root;
	}

	/**
	 * Deepest Depth = 6
	 *	       1
	 *	 	  / \ 
	 *	 	 2	 3
	 *	    / \  | \ 
	 *	   4   5 8  9
	 *	  / \	 | \
	 *   6	 7	 10 11
	 *   		/	/ \
	 *   	   12  13  14
	 *   			  /  \
	 *   			15	  16
	 *   				   \
	 *   					17
	 */
	public static Tree_Node getSampleTree2() {
		Tree_Node root = new Tree_Node("1");
		Tree_Node node2 = new Tree_Node("2");
		Tree_Node node3 = new Tree_Node("3");
		Tree_Node node4 = new Tree_Node("4");
		Tree_Node node5 = new Tree_Node("5");
		Tree_Node node6 = new Tree_Node("6");
		Tree_Node node7 = new Tree_Node("7");
		Tree_Node node8 = new Tree_Node("8");
		Tree_Node node9 = new Tree_Node("9");
		Tree_Node node10 = new Tree_Node("10");
		Tree_Node node11 = new Tree_Node("11");
		Tree_Node node12 = new Tree_Node("12");
		Tree_Node node13 = new Tree_Node("13");
		Tree_Node node14 = new Tree_Node("14");
		Tree_Node node15 = new Tree_Node("15");
		Tree_Node node16 = new Tree_Node("16");
		Tree_Node node17 = new Tree_Node("17");
		

		root.setLeft(node2);
		root.setRight(node3);

		node2.setLeft(node4);
		node2.setRight(node5);

		node4.setLeft(node6);
		node4.setRight(node7);
		
		node3.setLeft(node8);
		node3.setRight(node9);
		
		node8.setLeft(node10);
		node8.setRight(node11);
		
		node10.setLeft(node12);
		
		node11.setLeft(node13);
		node11.setRight(node14);
		
		node14.setLeft(node15);
		node14.setRight(node16);
		
		node16.setRight(node17);

		return root;
	}
	
	/**
	 *     0
	 *	  / \
	 * 	 1   0
	 *	    / \
	 *	   1   0
	 *	  / \
	 *	 1   1
	 */
	public static Tree_Node getUnivalTree1(){
		Tree_Node root = new Tree_Node("0");
		Tree_Node node2 = new Tree_Node("1");
		Tree_Node node3 = new Tree_Node("0");
		Tree_Node node4 = new Tree_Node("1");
		Tree_Node node5 = new Tree_Node("0");
		Tree_Node node6 = new Tree_Node("1");
		Tree_Node node7 = new Tree_Node("1");

		root.setLeft(node2);
		root.setRight(node3);

		node3.setLeft(node4);
		node3.setRight(node5);
		
		node4.setLeft(node6);
		node4.setRight(node7);
		return root;
	}
	
	/**
	 *    a
	 *	 / \
	 *	a   a
	 *	    /\
	 *	   a  a
	 *	       \
	 *	        A
	 * 
	 */
	public static Tree_Node getUnivalTree2(){
		Tree_Node root = new Tree_Node("a");
		Tree_Node node2 = new Tree_Node("a");
		Tree_Node node3 = new Tree_Node("a");
		Tree_Node node4 = new Tree_Node("a");
		Tree_Node node5 = new Tree_Node("a");
		Tree_Node node6 = new Tree_Node("A");

		root.setLeft(node2);
		root.setRight(node3);

		node3.setLeft(node4);
		node3.setRight(node5);
		
		node5.setRight(node6);
		return root;
	}
	
	/**
	 *    a
	 *	 / \
	 *	c   b
	 *	    /\
	 *	   b  b
	 *	       \
	 *	        b
	 * 
	 */
	public static Tree_Node getUnivalTree3(){
		Tree_Node root = new Tree_Node("a");
		Tree_Node node2 = new Tree_Node("b");
		Tree_Node node3 = new Tree_Node("b");
		Tree_Node node4 = new Tree_Node("b");
		Tree_Node node5 = new Tree_Node("b");
		Tree_Node node6 = new Tree_Node("b");

		root.setLeft(node2);
		root.setRight(node3);

		node3.setLeft(node4);
		node3.setRight(node5);
		
		node5.setRight(node6);
		return root;
	}
	
	/**
	 *    a
	 *	 / \
	 *	c   b
	 *	    /\
	 *	   b  b
	 *	  /    \
	 *	 q      b
	 * 	  \    /
	 * 	   q  r 
	 */
	public static Tree_Node getUnivalTree4(){
		Tree_Node root = new Tree_Node("a");
		Tree_Node node2 = new Tree_Node("b");
		Tree_Node node3 = new Tree_Node("b");
		Tree_Node node4 = new Tree_Node("b");
		Tree_Node node5 = new Tree_Node("b");
		Tree_Node node6 = new Tree_Node("b");
		Tree_Node node7 = new Tree_Node("q");
		Tree_Node node8 = new Tree_Node("q");
		Tree_Node node9 = new Tree_Node("r");

		root.setLeft(node2);
		root.setRight(node3);

		node3.setLeft(node4);
		node3.setRight(node5);
		
		node5.setRight(node6);
		
		node4.setLeft(node7);
		
		node7.setRight(node8);
		
		node6.setLeft(node9);
		return root;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Tree_Node getLeft() {
		return left;
	}

	public void setLeft(Tree_Node left) {
		this.left = left;
	}

	public Tree_Node getRight() {
		return right;
	}

	public void setRight(Tree_Node right) {
		this.right = right;
	}
}