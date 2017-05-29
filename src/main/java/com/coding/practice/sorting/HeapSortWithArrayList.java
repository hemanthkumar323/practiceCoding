package com.coding.practice.sorting;

import java.util.ArrayList;

public class HeapSortWithArrayList {
	
	public void sort(ArrayList<Integer> arr, int size) {
		buildMaxHeap(arr, size);
		
		int newSize = size-1;
		swap(arr, 0, newSize);
		while(newSize>0) {
			heapify(arr, 0, newSize);
			swap(arr, 0, --newSize);
		}
	}
	
	private void buildMaxHeap(ArrayList<Integer> arr, int size) {
		int i=(size-1)/2;
		while(i>=0)
			heapify(arr,i--, size);
	}
	
	private void heapify(ArrayList<Integer> arr, int ind, int size) {
		if(ind >= 0) {
			int left = 2*ind+1;
			int right = 2*ind+2;
			int max = ind;
			
			if(left < size && arr.get(max) < arr.get(left)) {
				max = left;
			}

			if(right < size && arr.get(max) < arr.get(right)) {
				max = right;
			}
			
			if(max != ind) {
				swap(arr, max, ind);
				heapify(arr, max, size);
			}
			
		}
	}
	
	private void swap(ArrayList<Integer> arr, int x, int y) {
		Integer temp = arr.get(x);
		arr.set(x, arr.get(y));
		arr.set(y, temp);
	}
	
	public void print(int arr[]) {
		for(int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
