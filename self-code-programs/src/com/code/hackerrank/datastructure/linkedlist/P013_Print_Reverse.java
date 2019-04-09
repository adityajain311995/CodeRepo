package com.code.hackerrank.datastructure.linkedlist;

/**
 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem
 * 
 * @author adijain4
 *
 */
public class P013_Print_Reverse {

	static void reversePrint(SinglyLinkedListNode head) {
		if(head == null) {
			return;
		}
		reversePrint(head.next);
		System.out.println(head.data);
	}
}
