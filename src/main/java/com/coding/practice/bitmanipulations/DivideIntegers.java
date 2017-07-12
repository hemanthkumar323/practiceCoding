package com.coding.practice.bitmanipulations;

public class DivideIntegers {

	public int divide(int dividend, int divisor) {
		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
		long quotient = 0;
		int temp = 0;
		long n = dividend, m = divisor;
		n = Math.abs(dividend);
		m = Math.abs(divisor);
		for (int i = 31; i >= 0; i--) {
			if (temp + (m << i) <= n) {
				temp += m << i;
				quotient |= 1 << i;
			}
		}
		if (sign < 0) quotient = -quotient;

	    // check for overflow and return
	    return quotient >= Integer.MAX_VALUE || quotient < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int)quotient;
	}

	public static void main(String args[]) {
		DivideIntegers d = new DivideIntegers();
		System.out.println(d.divide(-2147483648, -1));
	}

}
