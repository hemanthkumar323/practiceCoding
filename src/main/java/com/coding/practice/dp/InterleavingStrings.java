package com.coding.practice.dp;

/**
 * https://www.interviewbit.com/problems/interleaving-strings/
 * 
 * @author Hemanth
 *
 */
public class InterleavingStrings {

	public int isInterleave(String a, String b, String c) {
		return isInterleaveUtil(a, b, c);
	}

	private int isInterleaveUtil(String str1, String str2, String str3) {
		int str1Len = str1.length();
		int str2Len = str2.length();
		int str3Len = str3.length();

		if (str1Len + str2Len != str3Len)
			return 0;
		int dp[][] = new int[str1Len + 1][str2Len + 1];

		for (int i = 0; i <= str1Len; i++) {
			for (int j = 0; j <= str2Len; j++) {

				if (i == 0 && j == 0)
					dp[i][j] = 1;
				else if (i == 0)
					dp[i][j] = str2.charAt(j - 1) == str3.charAt(j - 1) ? dp[i][j - 1] : 0;
				else if (j == 0)
					dp[i][j] = str1.charAt(i - 1) == str3.charAt(i - 1) ? dp[i - 1][j] : 0;
				else if (str1.charAt(i - 1) == str3.charAt(i + j - 1) && str2.charAt(j - 1) != str3.charAt(i + j - 1))
					dp[i][j] = dp[i - 1][j];
				else if (str1.charAt(i - 1) != str3.charAt(i + j - 1) && str2.charAt(j - 1) == str3.charAt(i + j - 1))
					dp[i][j] = dp[i][j - 1];
				else if (str1.charAt(i - 1) == str3.charAt(i + j - 1) && str2.charAt(j - 1) == str3.charAt(i + j - 1))
					dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
			}
		}
		return dp[str1Len][str2Len];

	}

	public static void main(String args[]) {
		InterleavingStrings str = new InterleavingStrings();
		System.out.println(str.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}

}
