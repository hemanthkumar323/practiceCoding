package com.coding.practice.linkedlist;

public class ReverseLinkedList {

	// return the new Root Node
	public LinkedList process(LinkedList list) {
		LLNode root = list.getRoot();
		if (root == null)
			return list;
		LLNode prev = null;
		LLNode current = root;

		while (current != null) {
			LLNode next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		return new LinkedList(prev);
	}

	// return the new Root Node by reversing the list between start and end nodes
	public LinkedList process(LinkedList list, int start, int end) {
		LLNode root = list.getRoot();
		if (root == null)
			return list;
		// Traverse through m nodes
		int count = 1;
		LLNode temp = root;
		LLNode nodeBeforeStart = null;
		while(count < start) {
			nodeBeforeStart = temp;
			temp = temp.getNext();
			count++;
		}
		LLNode prev = null;
		LLNode current = temp;
		
		while (count <= end) {
			LLNode next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			count++;
		}
		if(nodeBeforeStart != null) 
			nodeBeforeStart.setNext(prev);
		else
			root = prev;
		temp.setNext(current);
		return new LinkedList(root);
	}
}
