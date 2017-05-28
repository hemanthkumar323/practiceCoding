package com.coding.pratice.sorting;

public class HeapSort {
	
	public void sort(int arr[], int size) {
		buildMaxHeap(arr, size);
		
		int newSize = size-1;
		swap(arr, 0, newSize);
		while(newSize>0) {
			heapify(arr, 0, newSize);
			swap(arr, 0, --newSize);
		}
	}
	
	private void buildMaxHeap(int arr[], int size) {
		int i=(size-1)/2;
		while(i>=0)
			heapify(arr,i--, size);
	}
	
	private void heapify(int arr[], int ind, int size) {
		if(ind >= 0) {
			int left = 2*ind+1;
			int right = 2*ind+2;
			int max = ind;
			
			if(left < size && arr[max] < arr[left]) {
				max = left;
			}

			if(right < size && arr[max] < arr[right]) {
				max = right;
			}
			
			if(max != ind) {
				swap(arr, max, ind);
				heapify(arr, max, size);
			}
			
		}
	}
	
	private void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	public void print(int arr[]) {
		for(int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
