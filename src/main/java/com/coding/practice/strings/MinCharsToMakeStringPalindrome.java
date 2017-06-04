package com.coding.practice.strings;

public class MinCharsToMakeStringPalindrome {
	
	public int solve(String text) {
		String reverse = reverse(text);
		
		String newStr = text + "$" + reverse;
		int lps[] = new LPS().constructLPS(newStr);
		int len = lps.length;
		return text.length() - lps[len-1];
	}
	
	private String reverse(String text) {
		byte strInBytes[] = text.getBytes();
		int i=0, j= text.length()-1;
		while(i<j) {
			byte temp = strInBytes[i];
			strInBytes[i] = strInBytes[j];
			strInBytes[j] = temp;
			i++; j--;
		}
		return new String(strInBytes);
	}
	
	public static void main(String args[]) {
		MinCharsToMakeStringPalindrome pal = new MinCharsToMakeStringPalindrome();
		System.out.println(pal.solve("aacd"));
	}

}
