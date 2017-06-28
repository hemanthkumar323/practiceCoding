package com.coding.practice.search;

import java.util.List;

import com.coding.practice.util.Utils;

public class MinInRotatedArray {
	
	// DO NOT MODIFY THE LIST
	public int findMin(final List<Integer> a) {
		int size = a.size();
		if(size == 1)
			return a.get(0);
		return traverse(a, 0, size-1, size);
	}

	public int traverse(List<Integer> arr, int start, int end, int size) {
		if (start > end)
			return -1;
		int mid = start + (end - start) / 2;
		int midMinusOne = (mid + size - 1) % size;
		int midPlusOne = (mid + 1) % size;
		if ((arr.get(mid) < arr.get(midMinusOne)) && (arr.get(mid) < arr.get(midPlusOne)))
			return arr.get(mid);

		// Series in increasing order
		if (arr.get(mid) < arr.get(end)) {
			return traverse(arr, start, mid - 1, size);

		} // mid+1..end in increasing order
		else {

			return traverse(arr, mid + 1, end, size);

		}

	}

	public static void main(String args[]) {
		int arr[] = { 5, 7, 8,1 };
		int size = arr.length;
		MinInRotatedArray search = new MinInRotatedArray();
		System.out.println(search.traverse(Utils.getListFromArray(arr), 0, size - 1, size));
	}

}
