package com.coding.practice.search;

import java.math.BigInteger;

public class Power {
	public int power(int x, int n, int d) {
		if(n == 0)
			return 1;
		if(n == 1)
			return x%d;
		BigInteger bigInt = BigInteger.valueOf(x);
		BigInteger mod = BigInteger.valueOf(d);
		BigInteger bigInt2  = bigInt.multiply(bigInt).mod(mod);
		
		if(n%2==0) {
			return power(bigInt2.intValue(), n/2, d);
		} else {
			int temp = power(bigInt2.intValue(), n/2, d);
			BigInteger tempBigInt = BigInteger.valueOf(temp);
			return tempBigInt.multiply(bigInt).mod(mod).intValue();
		}
	}
	
	public int pow(int x, int n, int d) {
		int remainder = power(x,n,d);
		if(remainder < 0)
			remainder +=d;
		return remainder;
	}
	
	public static void main(String args[]) {
		Power p = new Power();
		System.out.println(p.pow(71045970,41535484,64735492));
		//System.out.println(p.pow(2,8,6));
	}
}
