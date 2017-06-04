package com.coding.practice.search;

import java.util.ArrayList;

import com.coding.practice.util.Utils;

public class SortedInsertPosition {
	
	public int bsearch(ArrayList<Integer> arr, int key) {
		return search(arr, 0, arr.size()-1, key);
	}
	
	public int search(ArrayList<Integer> arr, int start, int end, int key) {
		if(start>end) {
			return 0;
		}
		if(key<=arr.get(start))
			return start;
		if(key>arr.get(end))
			return end+1;
		int mid = start + (end-start)/2;
		if(arr.get(mid) == key) {
			return mid;
		}
		
		if(arr.get(mid)>key) {
			return search(arr, start, mid-1, key);
		} 
		return search(arr, mid+1, end, key);
			
	}
	
	public static void main(String args[]) {
		int arr1[] = {1,4,7};
		ArrayList<Integer> temp = (ArrayList<Integer>)Utils.getListFromArray(arr1);
		SortedInsertPosition pos = new SortedInsertPosition();
		System.out.println(pos.bsearch(temp, 9));
	}

}
