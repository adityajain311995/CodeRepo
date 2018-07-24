package com.code.datastructure.trees;

public class Largest_Diameter {

	static int max_D = 0;
	
	public static void main(String[] args) {
		Tree_Node node = Tree_Node.getUnivalTree4();
		traverse(node);
		System.out.println(max_D);

	}
	
	
	public static void traverse(Tree_Node node){
		if(node==null)return;
		
		int current = findMaxDiameter(node);
		if(current>max_D){
			max_D = current;
		}
		traverse(node.getLeft());
		traverse(node.getRight());
	}
	
	public static int findMaxDiameter(Tree_Node node){
		return helper(node.getLeft()) + helper(node.getRight()) + 1;
	}
	
	public static int helper(Tree_Node node){
		
		if(node==null){
			return 0;
		}
		
		return Math.max(helper(node.getLeft()), helper(node.getRight())) + 1;
	}

}
