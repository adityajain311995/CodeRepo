package com.code.hackerrank.datastructure.linkedlist;
/**
 * https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem
 * @author adijain4
 *
 */
public class P017_Get_Node_Value {

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
    	if(head == null) {
    		return 0;
    	}
    	SinglyLinkedListNode start = head;
    	SinglyLinkedListNode end = head;
    	
    	for(int i=0; i<positionFromTail; i++) {
    		end = end.next;
    	}
    	
    	while(end.next!=null) {
    		start = start.next;
    		end = end.next;
    	}
    	
    	return start.data;
    }
	
}
