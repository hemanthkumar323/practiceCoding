package com.coding.practice.dp;

public class DistinctSubsequences {
	
	public int numDistinct(String S, String T) {
		int length1 = S.length();
		int length2 = T.length();
		return numDistinct(S, T, length1, length2);
	}
	
	private int numDistinct(String S, String T, int length1, int length2) {
		int dp[][] = new int[length1+1][length2+1];
		
		for(int i=0; i<=length1; i++) {
			for(int j=0; j<=length2; j++) {
				if(j==0)
					dp[i][j] = 1;
				else if(i==0)
					dp[i][j] = 0;
				else if(S.charAt(i-1) !=T.charAt(j-1)) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
		}
		for(int i=0; i<=length1; i++) {
			for(int j=0; j<=length2; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[length1][length2];
	}
	
	public static void main(String args[]) {
		DistinctSubsequences seq = new DistinctSubsequences();
		System.out.println(seq.numDistinct("monkey", "money"));
	}
}
