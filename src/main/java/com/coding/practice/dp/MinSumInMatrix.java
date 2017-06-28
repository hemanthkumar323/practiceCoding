package com.coding.practice.dp;

import java.util.ArrayList;

import com.coding.practice.util.Utils;

/**
 * https://www.interviewbit.com/problems/min-sum-path-in-matrix/
 * @author Hemanth
 *
 */
public class MinSumInMatrix {
	
	public int minPathSum(ArrayList<ArrayList<Integer>> a) {
		if(a == null)
			return 0;
		int m = a.size();
		int n = a.get(0).size();
		return minPathSumUtil(a, m, n);
	}
	
	private int minPathSumUtil(ArrayList<ArrayList<Integer>> a, int m, int n) {
		int dp[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = -1;
				else {
					int ele = a.get(i-1).get(j-1);
					int minEle = Integer.MAX_VALUE;
					if(dp[i-1][j] != -1)
						minEle = dp[i-1][j];
					if(dp[i][j-1] != -1)
						minEle = Math.min(minEle, dp[i][j-1]);
					dp[i][j] = minEle == Integer.MAX_VALUE ? ele : minEle + ele;
				}
			}
		}
		return dp[m][n]; 
	}
	public static void main(String args[]) {
		int arr1[] = {1,3,2};
		int arr2[] = {4,3,1};
		int arr3[] = {5,6,1};
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		output.add((ArrayList<Integer>)Utils.getListFromArray(arr1));
		output.add((ArrayList<Integer>)Utils.getListFromArray(arr2));
		output.add((ArrayList<Integer>)Utils.getListFromArray(arr3));
		MinSumInMatrix m = new MinSumInMatrix();
		System.out.println(m.minPathSum(output));
	}

}
