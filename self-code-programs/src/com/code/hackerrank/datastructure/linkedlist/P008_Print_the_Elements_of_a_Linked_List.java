package com.code.hackerrank.datastructure.linkedlist;

public class P008_Print_the_Elements_of_a_Linked_List {

    static void printLinkedList(SinglyLinkedListNode head) {
    	if(head==null) {
    		return;
    	}else {
    		System.out.println(head.data);
    		printLinkedList(head.next);
    	}

    }
	
}

