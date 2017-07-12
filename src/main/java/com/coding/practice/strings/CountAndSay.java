package com.coding.practice.strings;

public class CountAndSay {
	public String countAndSay(int a) {
		if (a <= 0)
			return "";
		String output = "1";
		int n = 1;
		while(n < a) {
			output = getNextString(output);
			n++;
		}
		return output;
	}
	
	private String getNextString(String str) {
		int len = str.length();
		String output = "";
		char currChar = str.charAt(0);
		int startInd = 0;
		
		int i=1;
		while(i<len) {
			while(i<len && str.charAt(i) == currChar) {
				i++;
			}
			output = output + (i - startInd) + currChar;
			startInd = i;
			if(i< len)
				currChar = str.charAt(i);
		}
		if(startInd < len) {
			output = output + (i - startInd) + currChar;
		}
		return output;
	}

	public static void main(String args[]) {
		CountAndSay c = new CountAndSay();
		System.out.println(c.countAndSay(10));
	}

}
