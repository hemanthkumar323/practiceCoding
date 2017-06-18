package com.coding.practice.dp;

public class WaysToDecode {
	public int numDecodings(String a) {
		if (a == null || a.trim().equals("") || Integer.parseInt(String.valueOf(a.charAt(0))) == 0)
			return 0;
		int length = a.length();

		int count[] = new int[length + 1];
		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= length; i++) {
			count[i] = 0;

			// If the last digit is not 0, then last digit must add to
			// the number of words
			if (Integer.parseInt(String.valueOf(a.charAt(i - 1))) > 0)
				count[i] = count[i - 1];

			// If second last digit is smaller than 2 and last digit is
			// smaller than 7, then last two digits form a valid character
			if (Integer.parseInt(String.valueOf(a.charAt(i - 2))) == 1
					|| (Integer.parseInt(String.valueOf(a.charAt(i - 2))) == 2
							&& Integer.parseInt(String.valueOf(a.charAt(i - 1))) < 7))
				count[i] += count[i - 2];
		}

		return count[length];

	}

	public static void main(String args[]) {
		WaysToDecode d = new WaysToDecode();
		// 4
		System.out.println(d.numDecodings("2611055971756562"));
		// 1
		System.out.println(d.numDecodings("100"));
		// 1
		System.out.println(d.numDecodings("22"));
	}

}
