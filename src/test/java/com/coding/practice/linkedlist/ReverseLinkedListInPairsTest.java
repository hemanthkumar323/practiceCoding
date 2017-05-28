package com.coding.practice.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class ReverseLinkedListInPairsTest {
	ReverseLinkedListInPairs sub = new ReverseLinkedListInPairs();
	
	@Test
	public void reverseEvenList() {
		LLNode rootNode = SampleLists.getEvenList();
		LinkedList list = new LinkedList(rootNode);
		LinkedList reverseList = sub.process(list);
		reverseList.printList();
		assertThat(reverseList.getRoot().getData()).isEqualTo(2);
	}
	
	@Test
	public void reverseOddList() {
		LLNode rootNode = SampleLists.getOddList();
		LinkedList list = new LinkedList(rootNode);
		LinkedList reverseList = sub.process(list);
		reverseList.printList();
		assertThat(reverseList.getRoot().getData()).isEqualTo(2);
	}
	
	

}
