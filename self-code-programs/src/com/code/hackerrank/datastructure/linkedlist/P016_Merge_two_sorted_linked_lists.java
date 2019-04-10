package com.code.hackerrank.datastructure.linkedlist;
/**
 * https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
 * @author adijain4
 *
 */
public class P016_Merge_two_sorted_linked_lists {

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

    	if(head1==null && head2==null) {
    		return null;
    	}else if(head1!=null && head2==null) {
    		return head1;
    	}else if(head1==null && head2!=null) {
    		return head2;
    	}else if(head1.data<=head2.data) {
    		head1.next = mergeLists(head1.next, head2);
    	}else {
    		SinglyLinkedListNode temp = head2.next;
    		head2.next = head1;
    		head1 = head2;
    		head2 = temp;
    		head1 = mergeLists(head1, head2);
    	}
    	
    	return head1;
    }
    
    
}
