package com.coding.practice.arrays;

import java.util.List;

public class MaxSumContiguousSubArray {
	
	public int maxSubArray(final List<Integer> a) {
		int size = a.size();
		int maxSum = a.get(0), temp = a.get(0);
		for(int i=1;i<size;i++) {
			if(temp + a.get(i) > a.get(i)) {
				temp= temp+a.get(i);
			} else {
				temp = a.get(i);
			}
			if(maxSum < temp) {
				maxSum = temp;
			}
		}
		return maxSum;
	}

}
