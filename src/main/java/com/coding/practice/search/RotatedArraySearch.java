package com.coding.practice.search;

public class RotatedArraySearch {
	
	public int traverse(int arr[], int start, int end, int searchKey) {
		if(start>end)
			return -1;
		int mid = start + (end-start)/2;
		if(arr[mid] == searchKey) 
			return mid;
		
		// Series in increasing order
		if(arr[start] <= arr[mid]) {
			if(arr[start] <= searchKey && searchKey < arr[mid]) {
				return traverse(arr, start, mid-1, searchKey);
			} else {
				return traverse(arr, mid+1, end, searchKey);
			}
		} // mid+1..end in increasing order
		else {
			if(arr[mid] < searchKey && searchKey <= arr[end]) {
				return traverse(arr, mid+1, end, searchKey);
			} else {
				return traverse(arr, start, mid-1, searchKey);
			}
		}
			
	}
	
	
	public static void main(String args[]) {
		int arr[] = {9, 16, 19,27,3,5,7,8};
		int size = arr.length;
		RotatedArraySearch search = new RotatedArraySearch();
		System.out.println(search.traverse(arr, 0, size-1, 29));
	}

}
