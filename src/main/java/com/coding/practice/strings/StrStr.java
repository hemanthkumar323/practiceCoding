package com.coding.practice.strings;

public class StrStr {
	int strStr(final String haystack, final String needle) {
		if (haystack.isEmpty() || needle.isEmpty())
			return -1;
		int haystack_ind = 0, needle_ind = 0, start = 0, needle_len = needle.length();
		int lps[] = constructLPS(needle);
		int textSize = haystack.length();
		while (haystack_ind < textSize && needle_ind < needle_len) {
				if (haystack.charAt(haystack_ind) == needle.charAt(needle_ind)) {
					needle_ind++;
					haystack_ind++;
				} else {
					if(needle_ind != 0)
						needle_ind = lps[needle_ind - 1];
					else
						haystack_ind++;
					start = haystack_ind - needle_ind;
				}
		}
		if (needle_ind == needle_len) {
			return start + 1;
		}
		return -1;
	}

	private int[] constructLPS(String text) {
		int size = text.length();
		int lps[] = new int[size];
		lps[0] = 0;
		int i = 1, currInd = 0;
		while (i < size) {
			if (text.charAt(i) == text.charAt(currInd)) {
				currInd++;
				lps[i++] = currInd;
			} else {
				if (currInd != 0)
					currInd = lps[currInd - 1];
				else
					lps[i++] = 0;
			}
		}
		return lps;
	}

	public static void main(String args[]) {
		StrStr s = new StrStr();
		System.out.println(s.strStr("abacbad", "abad"));
	}

}
