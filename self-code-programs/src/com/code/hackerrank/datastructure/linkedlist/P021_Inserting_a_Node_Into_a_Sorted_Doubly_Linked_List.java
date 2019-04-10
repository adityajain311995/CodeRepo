package com.code.hackerrank.datastructure.linkedlist;
/**
 * https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
 * @author adijain4
 *
 */
public class P021_Inserting_a_Node_Into_a_Sorted_Doubly_Linked_List {

	static DoublyLinkedListNode sortedInsert_nonRecursion(DoublyLinkedListNode head, int data) {
		if(head==null) {
			return new DoublyLinkedListNode(data);
		}
		
		DoublyLinkedListNode insertNode = new DoublyLinkedListNode(data);
		
		DoublyLinkedListNode node = head;
		while(node!=null) {
			if((node.prev == null || node.prev.data <= data ) && ( data <= node.data)) {
				if(node.prev!=null) {
					node.prev.next = insertNode;
				}else {
					head = insertNode;
				}
				insertNode.next = node;
				insertNode.prev = node.prev;
				node.prev = insertNode;
				break;
			} 
			
			if(node.next == null && node.data < data) {
				node.next = insertNode;
				break;
			}
			node = node.next;
		}
		
		return head;
    }
	
	
	static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
		DoublyLinkedListNode insertNode = new DoublyLinkedListNode(data);
		if(head == null) {
			return insertNode;
		}
		
		
		if(data <= head.data) {
			insertNode.next = head;
			head.prev = insertNode;
			head = insertNode;
		}else {
			DoublyLinkedListNode sorted = sortedInsert(head.next, data);
			head.next = sorted;
			sorted.prev = head;
		}
		
		return head;
	}
	
}
