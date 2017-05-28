package com.coding.practice.misc;

import org.junit.Test;

public final class LRUCacheTest {
	int size = 4;
	
	LRUCache cache = new LRUCache(size);
	
	@Test
	public void add() {
		cache.add(1);
		cache.printCurrentCacheState();
		
		cache.add(4);
		cache.add(5);
		
		cache.add(1);
		
		cache.add(3);
		
		cache.printCurrentCacheState();
		System.out.println();
		cache.add(7);
		cache.printCurrentCacheState();
		System.out.println();
		cache.add(8);
		cache.printCurrentCacheState();
		System.out.println();
		cache.add(9);
		
		
	}
}
