package com.coding.practice.trees;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

public class RMQTest {
	static int arr[] = {2,4,5,6,8,9,10,17,23,28,19,31,40,100};
	static RMQ rmq = new RMQ();
	
	@BeforeClass
	public static void init() {
		rmq.constructTree(arr);
	}
	
	@Test
	public void query1() {
		System.out.println(arr.length);
		rmq.printSegmentTree();
		assertThat(rmq.query(arr.length, 9, 13)).isEqualTo(19);
	}
}