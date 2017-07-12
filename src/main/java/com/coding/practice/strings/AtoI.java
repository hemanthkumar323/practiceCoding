package com.coding.practice.strings;

public class AtoI {

	public int atoi(final String a) {
		int len = a.length();
		if (len < 1)
			return 0;
		int num = 0;
		boolean isNegative = a.charAt(0) == '-';
		boolean isPositive = a.charAt(0) == '+';
		int i = isNegative || isPositive ? 1 : 0;
		while (i < len) {
			char ch = a.charAt(i++);
			if (isValid(ch)) {
				int temp = ch - 48;
				if (!isOverflow(num, num * 10, temp))
					num = num * 10 + temp;
				else {
					if (isNegative)
						return Integer.MIN_VALUE;
					else
						return Integer.MAX_VALUE;
				}
			} else {
				return isNegative ? num * -1 : num;
			}
		}
		return isNegative ? num * -1 : num;
	}

	private boolean isValid(char ch) {
		if (ch > 47 && ch < 58) {
			return true;
		}
		return false;
	}

	private boolean isOverflow(int x, int tenTimesX, int y) {
		if (tenTimesX < x || tenTimesX % 10 != 0)
			return true;
		if (tenTimesX + y < tenTimesX)
			return true;
		return false;

	}

	public static void main(String args[]) {
		AtoI a = new AtoI();
		System.out.println(a.atoi("+9"));
		System.out.println(a.atoi("5121478262"));
	}
}
