package com.coding.practice.knapsack;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
 * how many ways can we make the change? The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
 * So output should be 4. 
 * For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
 * So the output should be 5.
 * @author Hemanth
 *
 */
public class CoinChange {
	
	public int possibleCoinChange(int arr[], int N) {
		int dp[][] = new int[arr.length+1][N+1];
		
		for(int i=1; i<=arr.length; i++) {
			for(int j=0; j<=N; j++) {
				if(j==0)
					dp[i][j] = 1;
				else if(j>= arr[i-1]) {
					dp[i][j] = dp[i][j-arr[i-1]]+dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j];
				}
						
			}
		}
		print(dp,arr.length+1, N+1);
		return dp[arr.length][N];
	}
	
	private static int max(int a, int b) {
		return (a>b) ? a : b;
	}
	
	private void print(int arr[][], int m, int n) {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("\n");
		}
		
	}

}
