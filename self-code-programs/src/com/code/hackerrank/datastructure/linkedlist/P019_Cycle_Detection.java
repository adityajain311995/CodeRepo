package com.code.hackerrank.datastructure.linkedlist;
/**
 * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
 * @author adijain4
 *
 */
public class P019_Cycle_Detection {

    static boolean hasCycle(SinglyLinkedListNode head) {
    	if(head==null || head.next==null) {
    		return false;
    	}
    	
    	SinglyLinkedListNode slow = head;
    	SinglyLinkedListNode fast = head.next;
    	
    	while(fast!=null && fast.next!=null) {
    		slow = slow.next;
    		fast = fast.next.next;
    		if(slow == fast) {
    			return true;
    		}
    	}
        return false;

    }
	
}
