package com.coding.practice.search;

import java.math.BigInteger;

public class Sqrt {

	public int sqrt(int x) {
		if (x == 0 || x == 1)
			return x;
		int start = 1, end = x, ans = 0;
		BigInteger x_bigInt = BigInteger.valueOf(x);
		while (start <= end) {
			int mid = start + (end - start) / 2;
			BigInteger bigInt = BigInteger.valueOf(mid);
			BigInteger sqr = bigInt.multiply(bigInt);
			// If x is a perfect square
			if (sqr.equals(x_bigInt))
				return mid;

			// Since we need floor, we update answer when mid*mid is
			// smaller than x, and move closer to sqrt(x)
			if (sqr.compareTo(x_bigInt) == -1) {
				start = mid + 1;
				ans = mid;
			} else // If mid*mid is greater than x
				end = mid - 1;
		}
		return ans;
	}

	public static void main(String args[]) {
		Sqrt sqr = new Sqrt();
		System.out.println(sqr.sqrt(35));
	}

}
