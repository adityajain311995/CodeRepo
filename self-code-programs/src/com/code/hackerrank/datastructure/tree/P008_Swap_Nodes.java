package com.code.hackerrank.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P008_Swap_Nodes {

	public static void main(String[] args) {
		int[][] indexes = { { 2, 3 }, { -1, -1 }, { -1, -1 } };

		Node root = createTree(indexes);
		inOrder(root, new ArrayList<>());
	}

	static Integer[][] swapNodes(int[][] indexes, int[] queries) {
		Integer[][] result = null;
		Node root = createTree(indexes);
		for (int i = 0; i < queries.length; i++) {
			int k = queries[i];
			traverse(root, 1, k);

			List<Integer> elements = new ArrayList<>();
			inOrder(root, elements);
			if (result == null) {
				result = new Integer[queries.length][elements.size()];
			}
			result[i] = elements.toArray(new Integer[0]);

		}
		return result;
	}

	private static void traverse(Node node, int depth, int k) {
		if (node == null) {
			return;
		}
		if (depth % k == 0) {
			swap(node);
		}
		traverse(node.left, depth + 1, k);
		traverse(node.right, depth + 1, k);
	}

	private static void swap(Node node) {
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	private static Node createTree(int[][] indexes) {
		Queue<Node> que = new LinkedList<Node>();

		Node root = new Node(1);
		root.left = getNode(indexes[0][0]);
		root.right = getNode(indexes[0][1]);

		addQueue(que, root.left);
		addQueue(que, root.right);

		int i = 1;
		while (!que.isEmpty() || i < indexes.length) {
			Node current = que.remove();
			current.left = getNode(indexes[i][0]);
			current.right = getNode(indexes[i][1]);
			addQueue(que, current.left);
			addQueue(que, current.right);
			i++;
		}
		return root;
	}

	public static void inOrder(Node root, List<Integer> array) {
		if (root == null) {
			return;
		}
		inOrder(root.left, array);
		System.out.print(root.data + " ");
		array.add(root.data);
		inOrder(root.right, array);
	}

	private static Node getNode(Integer val) {
		if (val == -1) {
			return null;
		}
		return new Node(val);
	}

	private static void addQueue(Queue<Node> que, Node value) {
		if (value == null) {
			return;
		}
		que.add(value);
	}

}
