package com.coding.practice.dp;

import java.math.BigInteger;
import java.util.ArrayList;

public class NdigitsWithSumS {

	// A lookup table used for memoization

	// Memoizatiob based implementation of recursive
	// function
	int countRec(int[][] lookup, int n, int sum) {
		int mod = 1000000007;
		// Base case
		if (n == 0)
			return sum == 0 ? 1 : 0;

		// If this subproblem is already evaluated,
		// return the evaluated value
		if (lookup[n][sum] != -1)
			return lookup[n][sum];

		// Initialize answer
		int ans = 0;

		// Traverse through every digit and
		// recursively count numbers beginning
		// with it
		for (int i = 0; i < 10; i++)
			if (sum - i >= 0) {
				ans += countRec(lookup, n - 1, sum - i);
				ans = ans % mod;
			}

		return lookup[n][sum] = ans;
	}

	// This is mainly a wrapper over countRec. It
	// explicitly handles leading digit and calls
	// countRec() for remaining n.
	public int solve(int n, int sum) {
		int mod = 1000000007;
		int lookup[][] = new int[n + 1][sum + 1];
		// Initialize all entries of lookup table
		for (int i = 0; i <= n; ++i) {
			for (int j = 0; j <= sum; ++j) {
				lookup[i][j] = -1;
			}
		}

		// Initialize final answer
		int ans = 0;

		// Traverse through every digit from 1 to
		// 9 and count numbers beginning with it
		for (int i = 1; i <= 9; i++)
			if (sum - i >= 0) {
				ans += countRec(lookup, n - 1, sum - i);
				ans = ans % mod;
			}
		return ans;
	}

}
