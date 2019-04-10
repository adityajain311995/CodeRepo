package com.code.hackerrank.datastructure.linkedlist;

/**
 * https://www.hackerrank.com/challenges/compare-two-linked-lists/problem
 * 
 * @author adijain4
 *
 */
public class P015_Compare_two_linked_lists {

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    	if(head1==null && head1==null) {
    		return true;
    	}
    	if(head1==null || head2==null|| (head1.data != head2.data)) {
    		return false;
    	}
    	
    	return compareLists(head1.next, head2.next);
    }
	
}
