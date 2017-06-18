package com.coding.practice.dp;

import java.math.BigInteger;
import java.util.ArrayList;

public class Chords {

	public int chordCnt(int x) {
		int mod = 10000007;
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(1);
		list.add(2);

		for (int i = 3; i <= x; i++) {
			list.add(chordCntUtil(i, list, mod) % mod);
		}
		return list.get(x);

	}

	private int chordCntUtil(int x, ArrayList<Integer> list, int mod) {
		BigInteger temp = BigInteger.valueOf(0);
		for (int i = 0; i < x; i++) {
			BigInteger one = BigInteger.valueOf(list.get(i));
			BigInteger two = BigInteger.valueOf(list.get(x - i - 1));
			temp = temp.add(one.multiply(two)).remainder(BigInteger.valueOf(mod));

		}
		return temp.intValue();
	}

}
