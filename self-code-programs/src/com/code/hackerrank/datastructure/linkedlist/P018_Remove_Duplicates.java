package com.code.hackerrank.datastructure.linkedlist;
/**
 * https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
 * @author adijain4
 *
 */
public class P018_Remove_Duplicates {
	
	public static void main(String[] args) {
		SinglyLinkedListNode n1 = new SinglyLinkedListNode(3);
		SinglyLinkedListNode n2 = new SinglyLinkedListNode(3);
		SinglyLinkedListNode n3 = new SinglyLinkedListNode(3);
		SinglyLinkedListNode n4 = new SinglyLinkedListNode(4);
		SinglyLinkedListNode n5 = new SinglyLinkedListNode(5);
		SinglyLinkedListNode n6 = new SinglyLinkedListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		SinglyLinkedListNode node = removeDuplicates_nonRecursive(n1);
		
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
		
	}

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
    	if(head==null || head.next==null) {
    		return head;
    	}
    	
    	if(head.data == head.next.data) {
    		SinglyLinkedListNode temp = head.next.next;
    		while(temp!=null && head.data == temp.data) {
    			temp = temp.next;
    		}
    		head.next = removeDuplicates(temp);
    	}else {
    		head.next = removeDuplicates(head.next);
    	}
    	return head;
    }
    
    static SinglyLinkedListNode removeDuplicates_nonRecursive(SinglyLinkedListNode head) {
    	if(head==null || head.next==null) {
    		return head;
    	}
    	SinglyLinkedListNode node = head;
    	while(node!=null && node.next!=null) {
    		if(node.data == node.next.data) {
    			SinglyLinkedListNode temp = node.next.next;
    			while(temp!=null && node.data == temp.data) {
        			temp = temp.next;
        		}
    			node.next = temp;
    		}
    		node = node.next;
    	}
    	
    	return head;
    }
    
}
