package com.coding.practice.search;

import java.util.List;

import com.coding.practice.util.Utils;

public class UniqueEle {

	public int singleNumber(final List<Integer> a) {
		int[] bitSum = new int[32];
		int size = a.size();
		for (int i = 0; i < 32; ++i) {
			bitSum[i] = 0;
		}

		for (int i = 0; i < size; ++i) {
			int bitMask = 1;
			for (int j = 31; j >= 0; --j) {
				int bit = a.get(i) & bitMask;
				if (bit != 0) {
					bitSum[j] += 1;
				}

				bitMask = bitMask << 1;
			}
		}

		int result = 0;
		for (int i = 0; i < 32; ++i) {
			result = result << 1;
			result += bitSum[i] % 3;
		}
		return result;
	}

	public static void main(String args[]) {
		int arr[] = {1,2,3,2,2,4,3,1,3,1}; 
		UniqueEle ele = new UniqueEle();
		System.out.println(ele.singleNumber(Utils.getListFromArray(arr)));
	}
}
