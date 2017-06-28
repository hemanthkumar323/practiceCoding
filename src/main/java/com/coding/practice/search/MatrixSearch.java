package com.coding.practice.search;

import java.util.ArrayList;

import com.coding.practice.util.Utils;

public class MatrixSearch {

	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
		if (a == null)
			return 0;
		int rows = a.size();
		int cols = a.get(0).size();
		int start = 0, end = rows - 1;
		while (start<=end) {
			if (start >= rows || end < 0) {
				return 0;
			}
			int mid = start + (end - start) / 2;
			ArrayList<Integer> temp = a.get(mid);
			if (temp.get(0) <= b && temp.get(cols - 1) >= b) {

				// Do binary search on temp
				int ind = search(temp, 0, cols - 1, b);
				if (ind != -1)
					return 1;
				else
					return 0;

			} else {
				if (temp.get(0) < b) {
					start = mid + 1;

				} else {
					end = mid - 1;
				}
			}
		}
		return 0;
	}

	private int search(ArrayList<Integer> arr, int left, int right, int key) {
		if (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr.get(mid) == key)
				return mid + 1;
			if (arr.get(mid) > key)
				return search(arr, left, mid - 1, key);
			else
				return search(arr, mid + 1, right, key);
		}
		return -1;
	}

	public static void main(String args[]) {
		int arr1[] = { 1, 3, 5, 7 };
		int arr2[] = { 10, 11, 16, 20 };
		int arr3[] = { 23, 34, 40, 50 };
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		//input.add((ArrayList<Integer>) Utils.getListFromArray(arr1));
		//input.add((ArrayList<Integer>) Utils.getListFromArray(arr2));
		//input.add((ArrayList<Integer>) Utils.getListFromArray(arr3));
		input.add((ArrayList<Integer>) Utils.getListFromArray(new int[]{3}));
		input.add((ArrayList<Integer>) Utils.getListFromArray(new int[]{29}));
		input.add((ArrayList<Integer>) Utils.getListFromArray(new int[]{36}));
		input.add((ArrayList<Integer>) Utils.getListFromArray(new int[]{63}));
		input.add((ArrayList<Integer>) Utils.getListFromArray(new int[]{67}));
		input.add((ArrayList<Integer>) Utils.getListFromArray(new int[]{72}));
		input.add((ArrayList<Integer>) Utils.getListFromArray(new int[]{74}));
		input.add((ArrayList<Integer>) Utils.getListFromArray(new int[]{78}));
		input.add((ArrayList<Integer>) Utils.getListFromArray(new int[]{85}));

		MatrixSearch m = new MatrixSearch();
		System.out.println(m.searchMatrix(input, 41));
	}

}
