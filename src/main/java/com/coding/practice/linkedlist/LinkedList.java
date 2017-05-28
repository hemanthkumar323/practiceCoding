package com.coding.practice.linkedlist;

public class LinkedList {
	
	LLNode root;
	
	public LLNode getRoot() {
		return root;
	}

	public LinkedList(LLNode rootNode) {
		this.root = rootNode;
	}
	
	public int size() {
		LLNode temp = root;
		int count = 0;
		while(temp!= null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	
	public void printList() {
		LLNode temp = root;
		while(temp!= null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

}
