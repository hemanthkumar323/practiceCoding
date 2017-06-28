package com.coding.practice.dp;

/**
 * https://www.interviewbit.com/problems/evaluate-expression-to-true/
 * 
 * @author Hemanth
 *
 */
public class EvalExpToTrue {

	int dp[][][];

	public int cnttrue(String a) {
		if (a == null)
			return 0;
		int length = a.length();
		dp = new int[length][length][2];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {

				dp[i][j][0] = -1;
				dp[i][j][1] = -1;
			}
		}

		int count = ways(a, 0, length - 1, 'T');
		return count;
	}

	private int ways(String a, int start, int end, char expectedChar) {
		int length = a.length();
		int mod = 1003;
		if (end == start) {
			if (start >= length)
				return 0;
			if (a.charAt(start) == expectedChar) {
				return 1;
			} else
				return 0;
		}
		if (start > end)
			return 0;
		int ind = expectedChar == 'T' ? 0 : 1;
		if (dp[start][end][ind] != -1)
			return dp[start][end][ind];

		int count = 0;
		for (int i = start; i <= end; i++) {
			char temp = a.charAt(i);
			if (temp == '&') {
				if (expectedChar == 'T') {
					int left_true = ways(a, start, i - 1, 'T') % mod;
					if (left_true != 0) {
						int right_true = ways(a, i + 1, end, 'T') % mod;
						count += (left_true * right_true) % mod;
					}
				} else if (expectedChar == 'F') {
					int left_true = ways(a, start, i - 1, 'T') % mod;
					int left_false = ways(a, start, i - 1, 'F') % mod;
					int right_true = ways(a, i + 1, end, 'T') % mod;
					int right_false = ways(a, i + 1, end, 'F') % mod;

					count += (left_true * right_false) % mod;
					count += (left_false * right_true) % mod;
					count += (left_false * right_false) % mod;

				}
			} else if (temp == '^') {
				if (expectedChar == 'T') {
					int left_true = ways(a, start, i - 1, 'T') % mod;
					int left_false = ways(a, start, i - 1, 'F') % mod;
					if (left_true != 0) {
						int right_false = ways(a, i + 1, end, 'F') % mod;
						count += (left_true * right_false) % mod;
					}
					if (left_false != 0) {
						int right_true = ways(a, i + 1, end, 'T') % mod;
						count += (left_false * right_true) % mod;
					}
				} else if (expectedChar == 'F') {
					int left_true = ways(a, start, i - 1, 'T') % mod;
					int left_false = ways(a, start, i - 1, 'F') % mod;
					int right_true = ways(a, i + 1, end, 'T') % mod;
					int right_false = ways(a, i + 1, end, 'F') % mod;

					count += (left_false * right_false) % mod;
					count += (left_true * right_true) % mod;
				}
			} else if (temp == '|') {
				if (expectedChar == 'T') {
					int left_true = ways(a, start, i - 1, 'T') % mod;
					int left_false = ways(a, start, i - 1, 'F') % mod;
					if (left_true != 0) {
						int right_false = ways(a, i + 1, end, 'F') % mod;
						int right_true = ways(a, i + 1, end, 'T') % mod;

						count += (left_true * right_false) % mod;
						count += (left_true * right_true) % mod;
					}
					if (left_false != 0) {
						int right_true = ways(a, i + 1, end, 'T') % mod;
						count += (left_false * right_true) % mod;
					}
				} else if (expectedChar == 'F') {
					int left_true = ways(a, start, i - 1, 'F') % mod;
					int right_false = ways(a, i + 1, end, 'F') % mod;

					count += (left_true * right_false) % mod;
				}
			}
			count = count % mod;
		}
		dp[start][end][ind] = count;
		return count;

	}

	public static void main(String args[]) {
		String str = "T|F&T^T";
		EvalExpToTrue eval = new EvalExpToTrue();
		System.out.println(eval.cnttrue(str));
	}

}
