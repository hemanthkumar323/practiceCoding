package com.coding.practice.linkedlist;

public class RemoveDuplicates {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode a) {
		if(a==null)
			return a;
		int prev = a.val;
		ListNode temp = a.next, root = a;
		while(a != null) {
			if(prev != a.val) {
				prev = a.val;
				temp.next = a;
				temp = temp.next;
			}
			a = a.next;
		}
		temp.next = null;
		return root;
	}

}
