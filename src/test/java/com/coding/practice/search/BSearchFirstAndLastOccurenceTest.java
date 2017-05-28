package com.coding.practice.search;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class BSearchFirstAndLastOccurenceTest {
	BSearchFirstAndLastOccurence sub = new BSearchFirstAndLastOccurence();
	int arr[] = {22,22,22,33,44,55,55,55,55,55};
	
	@Test
	public void testfSearch() {
		assertThat(sub.fSearch(arr, 0, arr.length-1, 22)).isEqualTo(0);
	}
	
	@Test
	public void testLSearch() {
		assertThat(sub.lSearch(arr, 0, arr.length-1, 22)).isEqualTo(2);
	}

}
