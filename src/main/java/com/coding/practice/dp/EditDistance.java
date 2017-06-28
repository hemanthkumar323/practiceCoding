package com.coding.practice.dp;

/**
 * https://www.interviewbit.com/problems/edit-distance/
 * 
 * @author Hemanth
 *
 */
public class EditDistance {

	public int minDistance(String a, String b) {
		int size1 = a.length();
		int size2 = b.length();
		int dp[][] = new int[size1 + 1][size2 + 1];

		for (int i = 0; i <= size1; i++) {
			for (int j = 0; j <= size2; j++) {

				if (i == 0) {
					dp[i][j] = j;
				}

				else if (j == 0) {
					dp[i][j] = i;
				}

				else if (a.charAt(i - 1) == b.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
				}
			}
		}
		return dp[size1][size2];
	}
	
	

}
