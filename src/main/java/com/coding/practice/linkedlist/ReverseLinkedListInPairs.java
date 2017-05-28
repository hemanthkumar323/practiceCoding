package com.coding.practice.linkedlist;

public class ReverseLinkedListInPairs {
	
	public LLNode process(LLNode root) {
		if(root == null || root.getNext() == null) {
			return root;
		}
		LLNode nextNode = root.getNext();		
		root.setNext(process(nextNode.getNext()));
		nextNode.setNext(root);
		return nextNode;
	}
	
	public LinkedList process(LinkedList list) {
		LLNode newNode = process(list.getRoot());
		return new LinkedList(newNode);
	}
}
