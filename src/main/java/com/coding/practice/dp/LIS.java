package com.coding.practice.dp;

public class LIS {
	// To find the length of Longest Increasing Subsequence
	public int length(int arr[]) {
		int size = arr.length;
		int dp[] = new int[size];
		
		for (int i=size-1;i>=0;i--) {
			int maxLIS = 1;
			for(int j=i+1; j<size; j++) {
				if(arr[i] < arr[j] && maxLIS < 1+dp[j])
					maxLIS = 1+dp[j];
			}
			dp[i] = maxLIS;
		}
		return dp[0];
	}
}
