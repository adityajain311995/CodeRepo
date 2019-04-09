package com.code.hackerrank.datastructure.linkedlist;

public class P011_Insert_a_node_at_a_specific_position_in_a_linked_list {

	static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
		
		SinglyLinkedListNode prev = head;
		for(int i=1; i<position; i++) {
			prev = prev.next;
		}
		
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
		SinglyLinkedListNode temp = prev.next;
		prev.next = newNode;
		newNode.next = temp;
		
		return head;
	}
}
