package com.coding.pratice.math;

import java.util.ArrayList;

public class GoldbachPair {
	
	public ArrayList<Integer> primesum(int a) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(int i=2;i<=a/2;i++) {
			if(isPrime(i) && isPrime(a-i)) {
				output.add(i);
				output.add(a-i);
				return output;
			}
		}
		return output;
    }
	
	public boolean isPrime(int n) {
		if(n==2)
			return true;
		if(n%2==0)
			return false;
		int sqrtOfN = (int)Math.sqrt(n);
		for(int i=3; i<=sqrtOfN; i+=2) {
			if(n%i==0)
				return false;
		}
		return true;
	}

}
