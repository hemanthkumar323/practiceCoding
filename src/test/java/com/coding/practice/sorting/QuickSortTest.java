package com.coding.practice.sorting;

import org.junit.Test;

import com.coding.pratice.sorting.QuickSort;

public class QuickSortTest {
	
	private final QuickSort qsort = new QuickSort();
	private final int[] ascArr = {2,3,4,5,6,7};
	private final int[] descArr = {100,99,97,50,41,32,21};
	private final int[] randomArr = {22,45,54,31,87};
	
	@Test
	public void asc_sort() {
		qsort.sort(ascArr, 0, ascArr.length-1);
		System.out.println("Asc order test");
		print(ascArr);
	}
	
	@Test
	public void desc_sort() {
		qsort.sort(descArr, 0, descArr.length-1);
		System.out.println("Desc order test");
		print(descArr);
	}
	
	@Test
	public void random_sort() {
		qsort.sort(randomArr, 0, randomArr.length-1);
		System.out.println("Random order test");
		print(randomArr);
	}
	
	public void print(int arr[]) {
		for(int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
