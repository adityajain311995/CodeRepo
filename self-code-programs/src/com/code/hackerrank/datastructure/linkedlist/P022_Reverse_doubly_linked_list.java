package com.code.hackerrank.datastructure.linkedlist;

/**
 * https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem
 * 
 * @author adijain4
 *
 */
public class P022_Reverse_doubly_linked_list {

	static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

		DoublyLinkedListNode node = reverseList(head);
		
		while(node.prev!=null) {
			node = node.prev;
		}
		
		return node;
    }

	private static DoublyLinkedListNode reverseList(DoublyLinkedListNode head) {
		if(head.next==null) {
			head.prev = null;
			return head;
		}
		
		DoublyLinkedListNode reverse = reverseList(head.next);
		
		reverse.next = head;
		head.prev = reverse;
		head.next = null;
		
		return head;
	}

	
}
