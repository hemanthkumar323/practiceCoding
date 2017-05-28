package com.coding.practice.linkedlist;

public class SampleLists {

	// 1-> 2 -> 3 -> 4 -> 5
	public static LLNode getOddList() {
		LLNode node5 = new LLNode();
		node5.setData(5);

		LLNode node4 = new LLNode();
		node4.setData(4);
		node4.setNext(node5);

		LLNode node3 = new LLNode();
		node3.setData(3);
		node3.setNext(node4);

		LLNode node2 = new LLNode();
		node2.setData(2);
		node2.setNext(node3);

		LLNode node1 = new LLNode();
		node1.setData(1);
		node1.setNext(node2);

		return node1;
	}

	// 1-> 2 -> 3 -> 4 -> 5 -> 6
	public static LLNode getEvenList() {

		LLNode node6 = new LLNode();
		node6.setData(6);

		LLNode node5 = new LLNode();
		node5.setData(5);
		node5.setNext(node6);

		LLNode node4 = new LLNode();
		node4.setData(4);
		node4.setNext(node5);

		LLNode node3 = new LLNode();
		node3.setData(3);
		node3.setNext(node4);

		LLNode node2 = new LLNode();
		node2.setData(2);
		node2.setNext(node3);

		LLNode node1 = new LLNode();
		node1.setData(1);
		node1.setNext(node2);

		return node1;
	}
}
