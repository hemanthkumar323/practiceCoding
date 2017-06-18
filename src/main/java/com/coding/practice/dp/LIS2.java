package com.coding.practice.dp;

import java.util.ArrayList;
import java.util.List;

import com.coding.practice.util.Utils;

public class LIS2 {

	// To find the length of Longest Increasing Subsequence
	public int longestSubsequenceLength(final List<Integer> arr) {
		int size = arr.size();
		ArrayList<Integer> inc = new ArrayList<Integer>();
		ArrayList<Integer> dec = new ArrayList<Integer>();

		// Populate Length of Inc sequence intermediate array with end as 'i'
		for (int i = 0; i < size; i++) {
			int maxLIS = 1;
			for (int j = 0; j < i; j++) {
				if (arr.get(i) > arr.get(j) && maxLIS < 1 + inc.get(j))
					maxLIS = 1 + inc.get(j);
			}
			inc.add(maxLIS);
		}
		
		// System.out.println(inc);

		// Populate Length of Dec sequence intermediate array with start as 'i'
		for (int i = size - 1; i >= 0; i--) {
			int maxLIS = 1;
			for (int j = i + 1; j < size; j++) {
				if (arr.get(i) > arr.get(j) && maxLIS < 1 + dec.get(size - j - 1))
					maxLIS = 1 + dec.get(size - j - 1);
			}
			dec.add(maxLIS);
		}
		// System.out.println(dec);
		int max = 0;
		for (int i = 0; i < size; i++) {
			if (inc.get(i) + dec.get(size-i-1) - 1 > max)
				max = inc.get(i) + dec.get(size-i-1) -1;
		}
		return max;
	}
	
	public static void main(String args[]) {
		int arr[] = {1,11,2,10,4,5,2,1};
		LIS2 lis = new LIS2();
		System.out.println(lis.longestSubsequenceLength(Utils.getListFromArray(arr)));
	}
}
