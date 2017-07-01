package com.coding.practice.search;

import java.math.BigInteger;
import java.util.ArrayList;

import com.coding.practice.util.Utils;

public class PaintersPartition {
	
	public int paint(int a, int b, ArrayList<Integer> c) {
		if(c == null)
			return 0;
		int totalLength = 0;
		int size = c.size();
		for(int i=0; i<size; i++) {
			totalLength += c.get(i);
		}
		
		int start = 1, end = totalLength;
		while(start<=end) {
			int mid = start + (end - start)/2;
			if(canAllPaintersPaintWithMaxAsMid(a, mid, c) == 1) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		BigInteger mod = BigInteger.valueOf(10000003);
		return BigInteger.valueOf(start).multiply(BigInteger.valueOf(b)).mod(mod).intValue();
	}
	
	private int canAllPaintersPaintWithMaxAsMid(int a, int max, ArrayList<Integer> c) {
		int currSum = 0;
		int currPaintersCount = 1;
		int size = c.size();
		for(int i=0; i<size; i++) {
			int ele = c.get(i);
			if(ele > max)
				return 0;
			if(currSum + ele > max) {
				currSum = ele;
				currPaintersCount++;
				if(currPaintersCount > a) {
					return 0;
				}
			} else {
				currSum = currSum + ele;
			}
		}
		return 1;
	}
	
	public static void main(String args[]) {
		int arr[] = {1, 10};
		PaintersPartition p = new PaintersPartition();
		System.out.println(p.paint(2, 5, (ArrayList<Integer>)Utils.getListFromArray(arr)));
	}

}
