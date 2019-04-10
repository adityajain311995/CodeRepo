package com.code.hackerrank.datastructure.linkedlist;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem
 * 
 * @author adijain4
 *
 */
public class P010_Insert_a_node_at_the_head_of_a_linked_list {

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
    	SinglyLinkedListNode node = new SinglyLinkedListNode(data);
    	node.next = llist;
    	return node;
    }
	
}
