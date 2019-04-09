package com.code.hackerrank.datastructure.linkedlist;
/**
 * https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
 * @author adijain4
 *
 */
public class P009_Insert_a_Node_at_the_Tail_of_a_Linked_List {

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if(head==null){
            return new SinglyLinkedListNode(data);
        }
        SinglyLinkedListNode node = head;
        while(node.next!=null) {
            node = node.next;
        }
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        node.next = newNode;
        
        return head;
    }
	
}
