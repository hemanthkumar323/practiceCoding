package com.coding.practice.strings;

public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String a) {
		int size = a.length();
		boolean dp[][] = new boolean[size][size];
		filldiagonals(dp, size);
		for(int i=1; i<size; i++) {
			for(int j=0; j< size-i; j++) {
				int k = i+j;
				if(i==1) {
					dp[j][k] = (a.charAt(j) == a.charAt(k)) ? true : false;
				} else {
					dp[j][k] = (a.charAt(j) == a.charAt(k)) ? true : false;
					dp[j][k] = dp[j][k] & dp[j+1][k-1];
				}
			}
		}
		
		int maxLength = 0;
		String maxPalindrome = "";
		for(int i=0; i< size; i++) {
			for(int j=0; j< size; j++) {
				if(dp[i][j] == true && j-i+1 > maxLength) {
					maxLength = j-i+1;
					maxPalindrome = a.substring(i, j+1);
				}
			}
		}
		return maxPalindrome; 
		
	}
	
	private void filldiagonals(boolean dp[][], int size) {
		for(int i=0;i<size;i++)
			dp[i][i] = true;
	}
	
	private void print(boolean dp[][], int size){
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++)
				System.out.print(dp[i][j]+ " ");
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		String str1 = "aaaabaaa";
		LongestPalindromicSubstring string = new LongestPalindromicSubstring();
		//string.longestPalindrome(str1);
		System.out.println(string.longestPalindrome(str1));
	}

	
}
