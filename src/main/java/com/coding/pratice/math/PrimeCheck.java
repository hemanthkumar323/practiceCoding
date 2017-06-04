package com.coding.pratice.math;

public class PrimeCheck {
	
	public boolean isPrime(int n) {
		if(n%2==0)
			return true;
		int sqrtOfN = (int)Math.sqrt(n);
		for(int i=3; i<=sqrtOfN; i+=2) {
			if(n%i==0)
				return false;
		}
		return true;
	}

}
