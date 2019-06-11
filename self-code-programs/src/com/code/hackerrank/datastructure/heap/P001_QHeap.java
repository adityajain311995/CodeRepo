package com.code.hackerrank.datastructure.heap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

import com.code.hackerrank.datastructure.tree.Node;
/**
 * Not Completed
 * @author adijain4
 *
 */
public class P001_QHeap {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = Integer.parseInt(sc.nextLine());
    	
    	Node root = null;
    	for(int i=0; i<N; i++) {
    		String line = sc.nextLine();
    		if(line.charAt(0) =='1') {
    			root = addNode(root, line.substring(2));
    		}else if(line.charAt(0) =='2') {
    			root = deleteNode(root, line.substring(2));
    		}else {
    			System.out.println(root.data);
    		}
    	}
    	
    }

	private static Node deleteNode(Node node, String substring) {
		return null;
	}

	private static Node addNode(Node root, String value) {
		Node newNode = new Node(Integer.parseInt(value));
		if(root==null) {
			return newNode;
		}
		
		Queue<Node> que = new LinkedList<>();
		que.add(root);
		Node leafNode = null;
		while(!que.isEmpty()) {
			Node current = que.poll();
			if(current.left!=null && current.right!=null) {
				que.add(current.left);
				que.add(current.right);
				continue;
			}
			
			if(current.left==null) {
				current.left = newNode;
				leafNode = current;
				break;
			}
			if(current.right==null) {
				current.right = newNode;
				leafNode = current;
				break;
			}
		}
		minHeapifyNode(root, leafNode);
		return root;
	}
	
	private static void minHeapifyNode(Node root, Node node) {
		if(node==null) {
			return;
		}
		Node parent = null;
		Queue<Node> que = new LinkedList<>();
		que.add(root);
		while(!que.isEmpty()) {
			Node current = que.poll();
			if(current.left==node || current.right==node) {
				parent = current;
				break;
			}
			que.add(current.left);
			que.add(current.right);
		}
		
		if(node.left.data < node.data || node.right.data < node.data) {
			if(node.left.data < node.right.data) {
				swap(parent, node, node.left);
			}else {
				swap(parent, node, node.right);
			}
		}
		
		
	}

	private static void swap(Node parent, Node current, Node child) {
		if(parent.left==current) {
			parent.left = child;
		}else {
			parent.right = child;
		}
		if(current.left==child) {
			swapRight(current,child);
		}else {
			swapLeft(current,child);
		}
	}
	
	private static void swapLeft(Node current, Node child) {
		Node tempRight = current.right;
		current.left = child.left;
		current.right = child.right;
		child.left = current;
		child.right = tempRight;
	}

	private static void swapRight(Node current, Node child) {
		Node tempLeft = current.left;
		current.left = child.left;
		current.right = child.right;
		child.left = tempLeft;
		child.right = current;
	}

	private static Node getLastNode(Node root) {
		return null;
	}
	
}
