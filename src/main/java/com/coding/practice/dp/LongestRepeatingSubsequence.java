package com.coding.practice.dp;

/**
 * https://www.interviewbit.com/problems/repeating-sub-sequence/
 * @author Hemanth
 *
 */
public class LongestRepeatingSubsequence {
	
	public int anytwo(String a) {
		int res = lengthOfLongestRepeatingSubsequence(a,a);
		if(res>2)
			return res;
		return 0;
	}
	
	private int lengthOfLongestRepeatingSubsequence(String str1, String str2) {
		int length1 = str1.length();
		int length2 = str2.length();
		
		int dp[][] = new int[length1+1][length2+1];
		
		for(int i=0; i<=length1; i++) {
			for(int j=0; j<=length2; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				} else if( i == j) {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				} else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		for(int i=0; i<=length1; i++) { 
			for(int j=0; j<=length2; j++)
					System.out.print(dp[i][j] + " ");
			System.out.println();
		}
		return dp[length1][length2];
	}
	
	public static void main(String args[]) {
		String str = "abba";
		LongestRepeatingSubsequence seq = new LongestRepeatingSubsequence();
		System.out.println(seq.anytwo(str));
	}

}
