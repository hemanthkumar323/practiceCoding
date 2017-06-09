package com.coding.practice.bitmanipulations;

public class CountBits {
	int numSetBits(long a) {
		long temp = a;
		int count = 0;
		while (temp != 0) {
			long temp1 = a & 1;
			if (temp1 == 1)
				count++;
			temp = temp >> 1;
		}
		return count;
	}
	
	public long reverse(long a) {
		long res = 0;
		int count = 0;
		while(count<32) {
			long temp = (a & (1 << count));
	        if(temp > 0)
	            res |= (1L << (31 - count));
	        count++;
		}
		return res;
	}

	public static void main(String args[]) {
		CountBits count = new CountBits();
		System.out.println(count.reverse(3L));
	}

}
