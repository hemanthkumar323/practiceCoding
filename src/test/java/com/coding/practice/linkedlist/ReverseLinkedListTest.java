package com.coding.practice.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;

public class ReverseLinkedListTest {
	ReverseLinkedList sub = new ReverseLinkedList();
	
	@Test
	public void reverseEvenList() {
		LLNode root = SampleLists.getEvenList();
		LinkedList list= new LinkedList(root);
		LinkedList reversedList = sub.process(list);
		assertThat(reversedList.size()).isEqualTo(6);
		assertThat(reversedList.getRoot().getData()).isEqualTo(6);
	}
	
	@Test
	public void reverseOddList() {
		LLNode root = SampleLists.getOddList();
		LinkedList list= new LinkedList(root);
		LinkedList reversedList = sub.process(list);
		assertThat(reversedList.size()).isEqualTo(5);
		assertThat(reversedList.getRoot().getData()).isEqualTo(5);
	}
}
