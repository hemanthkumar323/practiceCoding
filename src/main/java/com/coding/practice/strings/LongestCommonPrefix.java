package com.coding.practice.strings;

import java.util.ArrayList;

import com.coding.practice.util.Utils;

public class LongestCommonPrefix {
	public String longestCommonPrefix(ArrayList<String> a) {
		String output = "";
		if(a == null)
			return output;
		int size = a.size();
		output = a.get(0);
		for(int i=1; i<size; i++) {
			output = getCommonPrefix(output, a.get(i));
			if(output.isEmpty())
				break;
		}
		return output;
		
	}
	
	private String getCommonPrefix(String str1, String str2) {
		int size1 = str1.length();
		int size2 = str2.length();
		int i=0;
		while(i<size1 && i<size2) {
			if(str1.charAt(i) == str2.charAt(i))
				i++;
			else
				break;
		}
		return str1.substring(0, i);
		
	}
	
	public static void main(String args[]) {
		String arr[] = {"abcf", "abcd", "bcd"};
		LongestCommonPrefix prefix = new LongestCommonPrefix();
		System.out.println(prefix.longestCommonPrefix((ArrayList<String>)Utils.getStringListFromArray(arr)));
	}

}
