package com.coding.practice.graphs;

public class SortedListToBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public TreeNode sortedListToBST(ListNode a) {
		int count = countNodes(a);
		return sortedListToBSTUtil(a, count);
	}
	
	private TreeNode sortedListToBSTUtil(ListNode a, int size) {
		if(size <= 0){
			return null;
		}
		TreeNode left = sortedListToBSTUtil(a, size/2);
		TreeNode currRoot = new TreeNode(a.val);
		currRoot.left = left;
		a = a.next;
		currRoot.right = sortedListToBSTUtil(a, size-size/2-1);
		return currRoot;
		
	}

	private int countNodes(ListNode a) {
		if (a == null)
			return 0;
		int count = 0;
		ListNode temp = a;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

}
