package com.coding.practice.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DoubleLinkedListTest {
	
	DoubleLinkedList dll = new DoubleLinkedList();
	
	@Test
	public void addNode() {
		dll.addNode(3);
		assertThat(dll.getRootNode().getData()).isEqualTo(3);
	}
	
	@Test
	public void deleteLastNode() {
		dll.addNode(3);
		dll.deleteLastNode();
		assertThat(dll.getRootNode()).isNull();
	}
	
	@Test
	public void addToFront() {
		dll.addNode(3);
		assertThat(dll.getRootNode().getData()).isEqualTo(3);
		dll.addToFront(5);
		assertThat(dll.getRootNode().getData()).isEqualTo(5);
	}
	
	@Test
	public void deleteNode() {
		dll.addNode(3);
		dll.addNode(5);
		dll.addNode(7);
		assertThat(dll.getRootNode().getData()).isEqualTo(3);
		dll.deleteNode(5);
		assertThat(dll.getRootNode().getData()).isEqualTo(3);
		assertThat(dll.size()).isEqualTo(2);
		
		// No node is present
		assertThat(dll.deleteNode(9)).isFalse();
		assertThat(dll.getRootNode().getData()).isEqualTo(3);
		assertThat(dll.size()).isEqualTo(2);
	}
	
	@Test
	public void pushToFront() {
		dll.addNode(3);
		dll.addNode(5);
		dll.addNode(7);
		assertThat(dll.getRootNode().getData()).isEqualTo(3);
		dll.pushToFront(5);
		assertThat(dll.getRootNode().getData()).isEqualTo(5);
		assertThat(dll.size()).isEqualTo(3);
		
		// No node is present
		dll.pushToFront(9);
		assertThat(dll.getRootNode().getData()).isEqualTo(5);
		assertThat(dll.size()).isEqualTo(3);
	}

}
