package com.code.hackerrank.datastructure.tree;

public class P006_Huffman_Decoding {

	void decode(String s, Node root) {
        Node current = root;
		for(char digit : s.toCharArray()) {
			if(digit == '0') {
				current = current.left;
			}else {
				current = current.right;
			}
			
			if(current.left == null && current.right == null) {
				System.out.print(current.data);
				current = root;
			}
		}
    }
	
}
