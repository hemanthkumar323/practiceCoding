package com.coding.practice.misc;

import java.util.HashMap;

import com.coding.practice.linkedlist.DoubleLinkedList;

public class LRUCache {

	int size;
	DoubleLinkedList list;
	HashMap<Integer, Boolean> map;

	public LRUCache(int size) {
		this.size = size;
		list = new DoubleLinkedList();
		map = new HashMap<Integer, Boolean>();
	}

	public synchronized boolean add(int ele) {
		if(map.containsKey(ele)) {
			list.pushToFront(ele);
			return true; 
		} else {
			map.put(ele, Boolean.TRUE);
			if(list.size() == size) {
				int lastNodeData = list.getLastNode();
				if(lastNodeData != -1) {
					map.remove(lastNodeData);
				}
				list.deleteLastNode();
			}
			list.addToFront(ele);
			return true;
		}
	}

	public void printCurrentCacheState() {
		list.printList();
	}

}
