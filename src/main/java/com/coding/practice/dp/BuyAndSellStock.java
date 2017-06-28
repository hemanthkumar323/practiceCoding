package com.coding.practice.dp;

import java.util.ArrayList;
import java.util.List;

import com.coding.practice.util.Utils;

public class BuyAndSellStock {
	
	public int maxProfit(final List<Integer> a) {
		ArrayList<Integer> min = new ArrayList<Integer>();
		ArrayList<Integer> max = new ArrayList<Integer>();
		int length = a.size();
		int minEle = a.get(0);
		min.add(minEle);
		for(int i = 1; i<length; i++) {
			if(minEle > a.get(i)) {
				minEle = a.get(i);
			}
			min.add(minEle);
		}
		
		int maxEle = a.get(length-1);
		max.add(maxEle);
		for(int i = length-2; i>=0; i--) {
			if(maxEle < a.get(i)) {
				maxEle = a.get(i);
			}
			max.add(maxEle);
		}
		
		int maxDiff = Integer.MIN_VALUE;
		for(int i=0; i< length; i++) {
			if(maxDiff < max.get(length-i-1) - min.get(i))
				maxDiff = max.get(length-i-1) - min.get(i);
		}
		
		return Math.max(0, maxDiff);
		
	}
	
	public static void main(String args[]) {
		int arr[] = {2,1};
		BuyAndSellStock b = new BuyAndSellStock();
		System.out.println(b.maxProfit(Utils.getListFromArray(arr)));
	}

}
