package com.coding.practice.linkedlist;

public class AddNumbersAsLists {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode a, ListNode b) {
		ListNode root = null, current = null;
		ListNode ptr1 =  a, ptr2 = b;
		int prevDiff = 0;
		while(ptr1 != null || ptr2 != null) {
			int ele1 = (ptr1 == null) ? 0 :ptr1.val;
			int ele2 = (ptr2 == null) ? 0 :ptr2.val;
			int res = ele1 + ele2 + prevDiff;
			int mod = res%10;
			ListNode temp = new ListNode(mod);
			if(root == null) {
				root = temp;
				current = temp;
			} else {
				current.next = temp;
				current = temp;
			}
			prevDiff = res/10;
			
			if(ptr1 != null)
				ptr1 = ptr1.next;
			if(ptr2 != null)
				ptr2 = ptr2.next;
		}
		if(prevDiff != 0) {
			ListNode temp = new ListNode(prevDiff);
			current.next = temp;
		}
		return root;
	}
	
}
