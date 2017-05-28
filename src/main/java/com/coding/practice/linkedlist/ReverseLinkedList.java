package com.coding.practice.linkedlist;

public class ReverseLinkedList {

	// return the new Root Node
	public LinkedList process(LinkedList list) {
		LLNode root = list.getRoot();
		if(root == null)
			return list;
		LLNode prev = null;
		LLNode current = root;
		
		while(current != null) {
			LLNode next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		return new LinkedList(prev);
	}
}
