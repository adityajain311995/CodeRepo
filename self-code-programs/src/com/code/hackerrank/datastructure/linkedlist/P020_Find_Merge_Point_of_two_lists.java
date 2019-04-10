package com.code.hackerrank.datastructure.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
 * 
 * @author adijain4
 *
 */
public class P020_Find_Merge_Point_of_two_lists {

	static int findMergeNode_lazy(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

		List<SinglyLinkedListNode> list = new ArrayList<>();

		while (head1 != null || head2 != null) {
			if (head1!=null) {
				if (list.contains(head1)) {
					return head1.data;
				} else {
					list.add(head1);
				}
				head1 = head1.next;
			}
			if (head2!=null) {
				if (list.contains(head2)) {
					return head2.data;
				} else {
					list.add(head2);
				}
				head2 = head2.next;
			}
			
		}

		return 0;
	}

	static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if(head1.next==null) {
            return head1.data;
        }else if(head2.next == null) {
            return head2.data;
        }        
        SinglyLinkedListNode temp = head1;
        while(temp.next!=null) {
            temp = temp.next;
        }

        temp.next = head2;
        SinglyLinkedListNode slow = head1;
        SinglyLinkedListNode fast = head1;
        
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                break;
            }
        }
        
        slow = head1;
        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow.data;
    }
	
}
