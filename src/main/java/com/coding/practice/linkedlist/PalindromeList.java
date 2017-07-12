package com.coding.practice.linkedlist;

/**
 * https://www.interviewbit.com/problems/palindrome-list/
 * @author Hemanth
 *
 */
public class PalindromeList {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/** 1-> 2 -> 3
	1 -> 2 -> 3-> 4-> 5
	
	1-> 2
	1->2 -> 3-> 4 */
	public int lPalin(ListNode A) {
		
		if(A == null || A.next == null)
			return 1;
		ListNode temp1 = A, temp2 = A.next;
		ListNode prevToTemp1 = A;
		while(temp2 != null && temp2.next != null) {
			prevToTemp1 = temp1;
			temp1 = temp1.next;
			temp2 = temp2.next.next;
		}
		
		// Even size list
		if(temp2 != null)
			temp1= temp1.next;
		prevToTemp1.next = reverse(temp1);
		
		temp1 = A;
		temp2 = prevToTemp1.next;
		while(temp2 != null && temp1 != prevToTemp1.next) {
			if(temp1.val != temp2.val)
				return 0;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return 1;
	}

	private ListNode reverse(ListNode node) {
		ListNode current = node, prev = null, next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

}
