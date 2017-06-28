package com.coding.practice.linkedlist;


public class MergeSortedLists {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		ListNode firstListRef = a;
		ListNode secondListRef = b;
		ListNode root = null, prevNode = null;
		while (firstListRef != null && secondListRef != null) {
			if(firstListRef.val > secondListRef.val ) {
				if(root == null) {
					root = secondListRef;
					prevNode = root;
				}
				else {
					prevNode.next = secondListRef;
					prevNode = prevNode.next;
				}
				secondListRef = secondListRef.next;
				
			} else {
				if(root == null) {
					root = firstListRef;
					prevNode = root;
				}
				else {
					prevNode.next = firstListRef;
					prevNode = prevNode.next;
				}
				firstListRef = firstListRef.next;
			}
			

		}

		while (firstListRef != null) {
			if(root == null)
				return firstListRef;
			prevNode.next = firstListRef;
			prevNode = prevNode.next;
			firstListRef = firstListRef.next;
		}

		while (secondListRef != null) {
			if(root == null)
				return secondListRef;
			prevNode.next = secondListRef;
			secondListRef = secondListRef.next;
			prevNode = prevNode.next;
			
		}
		return root;
	}
	
	public static void main(String args[]) {
		MergeSortedLists m = new MergeSortedLists();
		ListNode firstList = m.new ListNode(1);
		ListNode secondList = m.new ListNode(1);
		ListNode newRoot = m.mergeTwoLists(firstList, secondList);
		System.out.println(newRoot);
	}

}
