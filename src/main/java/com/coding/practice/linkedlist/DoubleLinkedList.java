package com.coding.practice.linkedlist;

public class DoubleLinkedList {

	DLLNode rootNode;

	// Add Node to the end of the list
	public void addNode(int data) {
		DLLNode newNode = new DLLNode();
		newNode.setData(data);
		if (rootNode == null) {
			rootNode = newNode;
			return;
		}

		DLLNode temp = rootNode;
		while (temp.getNext() != null)
			temp = temp.getNext();
		temp.setNext(newNode);
		newNode.setPrev(temp);
		return;

	}

	// Add Node to the start of the list and makes as root node
	public synchronized void addToFront(int data) {
		DLLNode newNode = new DLLNode();
		newNode.setData(data);
		newNode.setNext(rootNode);
		if (rootNode != null) {
			rootNode.setPrev(newNode);
		}
		rootNode = newNode;
	}
	
	// Add Node to the start of the list and makes as root node
		public synchronized void pushToFront(int data) {
			// If the data is already in the rootNode do nothing 
			if(rootNode.getData() == data)
				return;
			boolean isDataExists = deleteNode(data);
			if(isDataExists)
				addToFront(data);
		}
	

	public synchronized boolean deleteLastNode() {
		if(rootNode == null) 
			return false;
		if(rootNode.getNext() == null) {
			rootNode = null;
			return true;
		}
		DLLNode temp = rootNode;
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.getPrev().setNext(null);
		return true;
	}
	
	public int getLastNode() {
		if(rootNode == null)
			return -1;
		DLLNode temp = rootNode;
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp.getData();
	}
	
	public boolean deleteNode(int data) {
		if(rootNode == null)
			return false;
		if(rootNode.getData() == data) {
			rootNode = rootNode.getNext();
			if(rootNode != null)
				rootNode.setPrev(null);
		}
		DLLNode temp = rootNode;
		while(temp.getData()!= data && temp.getNext() != null) {
			temp = temp.getNext();
		}
		if(temp.getData() != data) 
			return false;
		DLLNode nextNode = temp.getNext();
		temp.getPrev().setNext(nextNode);
		if(nextNode != null)
			nextNode.setPrev(temp.getPrev());
		return true;
	}
	
	public void printList() {
		DLLNode temp = rootNode;
		while(temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
	
	public int size() {
		int count = 0;
		DLLNode temp = rootNode;
		while(temp != null) {
			temp = temp.getNext();
			count++;
		}
			
		return count;
		
	}
	
	public DLLNode getRootNode() {
		return rootNode;
	}

}
