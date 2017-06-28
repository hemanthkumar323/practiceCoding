package com.coding.practice.dp;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/max-sum-without-adjacent-elements/
 * 
 * @author Hemanth
 *
 */
public class MaxSumWithoutAdjacentEle {
	public int adjacent(ArrayList<ArrayList<Integer>> a) {
		if (a == null)
			return 0;
		int size = a.get(0).size();

		ArrayList<Integer> maxList = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			int max = Math.max(a.get(0).get(i), a.get(1).get(i));
			maxList.add(max);
		}

		int res = maxSum(maxList, size);
		return res;

	}

	private int maxSum(ArrayList<Integer> list, int size) {
		if(size == 0)
			return 0;
		if(size == 1)
			return list.get(0);
		if(size == 2) {
			return Math.max(list.get(0), list.get(1));
		}
		ArrayList<Integer> dp = new ArrayList<Integer>();
		dp.get(list.get(0));
		dp.get(list.get(1));
		
		for(int i=2; i<size; i++) {
			int maxEle = Integer.MIN_VALUE;
			for(int j=0; j<i-1; j++) {
				maxEle = Math.max(maxEle, list.get(i) + dp.get(j));
			}
			dp.add(maxEle);
		}
		return Math.max(dp.get(size-1), dp.get(size-2));
	}
	
	

}
