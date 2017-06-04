package com.coding.practice.search;

import java.util.List;

public class BSearchFirstAndLastOccurence {
	
	public int fSearch(int arr[], int left, int right, int key) {
		if(left <= right) {
			int mid = left + (right-left)/2;
			if (arr[mid] == key) {
				if(mid-1 < 0 || arr[mid-1]<key)
					return mid;
				else
					return fSearch(arr, left, mid-1, key);
				
			}
			if(arr[mid] > key)
				return fSearch(arr, left, mid-1, key);
			else
				return fSearch(arr, mid+1, right, key);
		}
		return -1;
	}
	
	public int lSearch(int arr[], int left, int right, int key) {
		if(left <= right) {
			int mid = left + (right-left)/2;
			if (arr[mid] == key) {
				if(mid+1 >= arr.length || arr[mid+1]>key)
					return mid;
				else
					return lSearch(arr, mid+1, right, key);
				
			}
			if(arr[mid] > key)
				return lSearch(arr, left, mid-1, key);
			else
				return lSearch(arr, mid+1, right, key);
		}
		return -1;
	}
	
	
	// WIth Lists
	public int fSearch(List<Integer> arr, int left, int right, int key) {
		if(left <= right) {
			int mid = left + (right-left)/2;
			if (arr.get(mid) == key) {
				if(mid-1 < 0 || arr.get(mid-1)<key)
					return mid;
				else
					return fSearch(arr, left, mid-1, key);
				
			}
			if(arr.get(mid) > key)
				return fSearch(arr, left, mid-1, key);
			else
				return fSearch(arr, mid+1, right, key);
		}
		return -1;
	}
	
	public int lSearch(List<Integer> arr, int left, int right, int key) {
		if(left <= right) {
			int mid = left + (right-left)/2;
			if (arr.get(mid) == key) {
				if(mid+1 >= arr.size() || arr.get(mid+1)>key)
					return mid;
				else
					return lSearch(arr, mid+1, right, key);
				
			}
			if(arr.get(mid) > key)
				return lSearch(arr, left, mid-1, key);
			else
				return lSearch(arr, mid+1, right, key);
		}
		return -1;
	}
	
	public int bSearch(int arr[], int searchKey) {
		int start = fSearch(arr, 0, arr.length-1, searchKey);
		int end = lSearch(arr, 0, arr.length-1, searchKey);
		if(start == -1 || end == -1)
			return -1;
		return end - start;
		
	}

}
