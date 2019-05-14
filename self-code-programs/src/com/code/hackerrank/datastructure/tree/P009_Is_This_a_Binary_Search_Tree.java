package com.code.hackerrank.datastructure.tree;

public class P009_Is_This_a_Binary_Search_Tree {

	boolean checkBST(Node root) {
		if (root == null) {
			return true;
		}

		return isLeftFine(root) && isRightFine(root) && checkBST(root.left) && checkBST(root.right);
	}

	boolean isLeftFine(Node node) {
		if (node.left == null || node.left.data < node.data) {
			return true;
		} else {
			return false;
		}
	}

	boolean isRightFine(Node node) {
		if (node.right == null || node.data < node.right.data) {
			return true;
		} else {
			return false;
		}
	}

}
