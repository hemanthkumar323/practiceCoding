package com.coding.practice.search;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class BinarySearchTest {
	BinarySearch sub = new BinarySearch();
	int arr[] = {24,26,29, 40,50};
	
	@Test
	public void searchValidKey() {
		int pos = sub.bSearch(arr, 29);
		assertThat(pos).isEqualTo(3);
	}
	
	@Test
	public void searchInvalidKey() {
		int pos = sub.bSearch(arr, 28);
		assertThat(pos).isEqualTo(-1);
	}
	
}
