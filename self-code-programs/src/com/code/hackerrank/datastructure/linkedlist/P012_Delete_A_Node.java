package com.code.hackerrank.datastructure.linkedlist;

/**
 * https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem
 * 
 * @author adijain4
 *
 */
public class P012_Delete_A_Node {
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
    	if(position==0) {
    		return head.next;
    	}
    	SinglyLinkedListNode node = head;
    	for(int i=0; i<position-1; i++) {
    		node = node.next;
    	}
    	node.next = node.next.next;
    	return head;
    }
}
