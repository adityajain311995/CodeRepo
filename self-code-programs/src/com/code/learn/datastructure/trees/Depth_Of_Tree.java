package com.code.learn.datastructure.trees;

import com.code.bean.Company;

public class Depth_Of_Tree {

	public static void main(String[] args) {
		/*Tree_Node node1 = Tree_Node.getSampleTree1();
		Tree_Node node2 = Tree_Node.getSampleTree2();
		System.out.println(depth(node1));
		System.out.println(depth(node2));*/
		
		Company c1 = new Company("SAP", "BLR");
		Company c2 = new Company("SAP", "BLR");
		
		System.out.println(c1.equals(c2));
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		
	}
	
	public static int depth(Tree_Node root){
		if(root == null || root.getLeft()==null && root.getRight()==null){
			return 0;
		}
		return Math.max(depth(root.getLeft()), depth(root.getRight())) + 1;
	}

}
