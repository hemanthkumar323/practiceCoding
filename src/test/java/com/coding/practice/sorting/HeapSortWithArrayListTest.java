package com.coding.practice.sorting;

import java.util.ArrayList;

import org.junit.Test;

public class HeapSortWithArrayListTest {

	private final HeapSortWithArrayList hSort = new HeapSortWithArrayList();
	private final int[] ascArr = {2,3,4,5,6,7};
	private final int[] descArr = {100,99,97,50,41,32,21};
	private final int[] randomArr = { 1, 2, 7, 0, 9, 3, 6, 0, 6};
	
	public ArrayList<Integer> getListFromArray(int arr[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++)
			list.add(arr[i]);
		return list;
	}
	
	@Test
	public void asc_sort() {
		ArrayList<Integer> input = getListFromArray(ascArr);
		hSort.sort(input, ascArr.length);
		System.out.println("Asc order test");
		print(input);
	}
	
	@Test
	public void desc_sort() {
		ArrayList<Integer> input = getListFromArray(descArr);
		hSort.sort(input, descArr.length);
		System.out.println("Desc order test");
		print(input);
	}
	
	@Test
	public void random_sort() {
		ArrayList<Integer> input = getListFromArray(randomArr);
		hSort.sort(input, randomArr.length);
		System.out.println("Random order test");
		print(input);
	}
	
	public void print(ArrayList<Integer> arr) {
		for(int i=0; i< arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
