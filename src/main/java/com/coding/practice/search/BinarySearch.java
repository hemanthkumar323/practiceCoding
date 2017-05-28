package com.coding.practice.search;

public class BinarySearch {
	
	public int search(int arr[], int left, int right, int key) {
		if(left < right) {
			int mid = left + (right-left)/2;
			if (arr[mid] == key)
				return mid+1;
			if(arr[mid] > key)
				return search(arr, left, mid-1, key);
			else
				return search(arr, mid+1, right, key);
		}
		return -1;
	}
	
	public int bSearch(int arr[], int searchKey) {
		return search(arr, 0, arr.length-1, searchKey);
	}
}
