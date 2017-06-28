package com.coding.practice.dp;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/unique-paths-in-a-grid/
 * 
 * @author Hemanth
 *
 */
public class UniquePaths {

	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
		if (a == null)
			return 0;
		int m = a.size();
		int n = a.get(0).size();
		return uniquePathsWithObstaclesUtil(a, m, n);
	}

	private int uniquePathsWithObstaclesUtil(ArrayList<ArrayList<Integer>> a, int m, int n) {

		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 1 && j == 1 && a.get(i - 1).get(j - 1) == 0)
					dp[i][j] = 1;
				else if (i == 0 || j == 0 || a.get(i - 1).get(j - 1) == 1)
					dp[i][j] = 0;
				else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m][n];
	}

}
