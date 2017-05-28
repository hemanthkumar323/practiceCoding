package com.coding.practice.sorting;

import org.junit.Test;

import com.coding.practice.sorting.HeapSort;

public class HeapSortTest {
	
	private final HeapSort hSort = new HeapSort();
	private final int[] ascArr = {2,3,4,5,6,7};
	private final int[] descArr = {100,99,97,50,41,32,21};
	private final int[] randomArr = {22,45,54,31,87};
	
	@Test
	public void asc_sort() {
		hSort.sort(ascArr, ascArr.length);
		System.out.println("Asc order test");
		print(ascArr);
	}
	
	@Test
	public void desc_sort() {
		hSort.sort(descArr, descArr.length);
		System.out.println("Desc order test");
		print(descArr);
	}
	
	@Test
	public void random_sort() {
		hSort.sort(randomArr, randomArr.length);
		System.out.println("Random order test");
		print(randomArr);
	}
	
	public void print(int arr[]) {
		for(int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
