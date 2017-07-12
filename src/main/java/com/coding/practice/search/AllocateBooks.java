package com.coding.practice.search;

import java.math.BigInteger;
import java.util.ArrayList;

import com.coding.practice.util.Utils;

/**
 * https://www.interviewbit.com/problems/allocate-books/
 * 
 * @author Hemanth
 *
 */
public class AllocateBooks {
	public int books(ArrayList<Integer> a, int b) {
		if (a == null || a.size() < b)
			return -1;
		int size = a.size();
		int sum = 0;

		for (int i = 0; i < size; i++) {
			sum = sum + a.get(i);
		}

		int start = 0, end = sum;
		int result = Integer.MAX_VALUE;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isPossible(a, size, b, mid) == true) {
				result = Math.min(result, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	private boolean isPossible(ArrayList<Integer> a, int size, int b, int maxSum) {
		int noOfStudentsRequired = 1;
		int currSum = 0;

		for (int i = 0; i < size; i++) {
			int ele = a.get(i);
			if (ele > maxSum) {
				return false;
			}

			if (currSum + ele > maxSum) {
				noOfStudentsRequired++;
				currSum = ele;

				if (noOfStudentsRequired > b)
					return false;
			} else {
				currSum = currSum + ele;
			}
		}
		return true;

	}

	public static void main(String args[]) {
		int arr[] = {12,34,67,90};
		int b = 2;
		AllocateBooks a = new AllocateBooks();
		System.out.println(a.books((ArrayList<Integer>) Utils.getListFromArray(arr), b));
	}
}
