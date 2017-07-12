package com.coding.practice.strings;

public class LPS {

	public int[] constructLPS(String text) {
		int size = text.length();
		int lps[] = new int[size];
		lps[0] = 0;
		int i = 1, len =0;
		while(i<size) {
			if(text.charAt(i) == text.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if(len != 0) {
					len = lps[len-1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
	
	public static void main(String args[]) {
		LPS lps = new LPS();
		int temp[] = lps.constructLPS("abad");
		for(int i=0; i<temp.length; i++)
		System.out.println(temp[i]);
	}
}
