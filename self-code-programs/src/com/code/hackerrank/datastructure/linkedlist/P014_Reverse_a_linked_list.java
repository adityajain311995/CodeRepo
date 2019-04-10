package com.code.hackerrank.datastructure.linkedlist;
/**
 * https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
 * @author adijain4
 *
 */
public class P014_Reverse_a_linked_list {

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
    	if(head==null) {
    		return head;
    	}
    	SinglyLinkedListNode prev = head;
    	SinglyLinkedListNode currNode = head.next;
    	SinglyLinkedListNode next;
    	while(currNode!=null) {
    		next = currNode.next;
    		currNode.next = prev;
    		prev = currNode;
    		currNode = next;
    	}
    	head.next = null;
    	return prev;
    }
    
    static SinglyLinkedListNode recursion_reverse(SinglyLinkedListNode head) {
    	if(head==null || head.next==null) {
    		return head;
    	}
    	
    	SinglyLinkedListNode remainNode = recursion_reverse(head.next);
    	head.next.next = head;
    	head.next = null;
    	
    	return remainNode;
    }
	
}
