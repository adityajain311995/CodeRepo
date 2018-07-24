package com.code.dailycoding;

import com.code.datastructure.trees.Tree_Node;

/**
 * This problem was asked by Google.
 * A unival tree (which stands for "universal value") is a tree 
 * where all nodes under it have the same value.
 * Given the root to a binary tree, count the number of unival subtrees.
 * For example, the following tree has 5 unival subtrees:
 *    0
 *   / \
 *  1   0
 *     / \
 *    1   0
 *   / \
 *  1   1
 *  
 */
public class Unival_Tree {

	private static int count = 0;
	
	public static void main(String[] args) {
		Tree_Node node = Tree_Node.getUnivalTree3();
		univalSubTrees(node);
		System.out.println(count);
		System.out.println(count_unival_subtrees(node));
	}
	
	private static void univalSubTrees(Tree_Node node){
		if(isUnival(node)){
			count++;
		}
		if(node.getLeft()!=null)univalSubTrees(node.getLeft());
		if(node.getRight()!=null)univalSubTrees(node.getRight());
	}
	
	private static int count_unival_subtrees(Tree_Node root){
		if(root == null){
			return 0;
		}
		int left = count_unival_subtrees(root.getLeft());
		int right = count_unival_subtrees(root.getRight());
		
		if(isUnival(root)){
			return 1 + left + right;
		}
		return left + right;
	}
	
	private static boolean isUnival(Tree_Node root) {
		return unival_Helper(root, root.getData());
	}
	
	private static boolean unival_Helper(Tree_Node root, String parentData){
		if(root==null)return true;
		if(root.getData() == parentData){
			return unival_Helper(root.getLeft(), root.getData()) && unival_Helper(root.getRight(), root.getData());
		}
		return false;
	}
	
}
