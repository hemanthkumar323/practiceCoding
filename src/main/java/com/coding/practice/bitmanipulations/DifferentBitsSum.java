package com.coding.practice.bitmanipulations;

import java.math.BigInteger;
import java.util.ArrayList;

import com.coding.practice.util.Utils;

public class DifferentBitsSum {

	public int cntBits(ArrayList<Integer> A) {
		int mod = 1000000007;
		BigInteger mod_bigInt = BigInteger.valueOf(mod);
		int sum = 0;
		int size = A.size();
		for (int i = 31; i >= 0; i--) {
			int count = 0;
			for (int j = 0; j < size; j++) {
				if ((A.get(j) & 1 << i) == 0)
					count++;

			}
			int temp = BigInteger.valueOf(count).multiply(BigInteger.valueOf(size - count)).multiply(BigInteger.valueOf(2))
					.mod(mod_bigInt).intValue();
			sum = BigInteger.valueOf(sum).add(BigInteger.valueOf(temp)).mod(mod_bigInt).intValue();

		}

		return sum;
	}

	public static void main(String args[]) {
		int arr[] = { 81, 13, 2, 7, 96 };
		DifferentBitsSum sum = new DifferentBitsSum();
		System.out.println(sum.cntBits((ArrayList<Integer>) Utils.getListFromArray(arr)));
	}

}
