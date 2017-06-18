package com.coding.practice.greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/assign-mice-to-holes/
 * 
 * @author Hemanth
 *
 */
public class MiceToHoles {
	public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
		Collections.sort(a);
		Collections.sort(b);
		int size = a.size();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			int diff = Math.abs(a.get(i) - b.get(i));
			if (diff > max)
				max = diff;
		}
		return max;
	}

	public int candy(ArrayList<Integer> ratings) {
		ArrayList<Integer> right = new ArrayList<Integer>();
		ArrayList<Integer> left = new ArrayList<Integer>();
		int size = ratings.size();
		int count = 0;
		for (int i = 0; i < size; i++) {
			if(i==0 || ratings.get(i) <= ratings.get(i-1))
				left.add(1);
			else
				left.add(left.get(i-1) + 1);
		}
		for (int i = size-1; i >=0; i--) {
			if(i==size-1 || ratings.get(i) <= ratings.get(i+1))
				right.add(1);
			else
				right.add(right.get(i+1) + 1);
		}
		
		for(int i=0; i<size; i++) {
			count += max(left.get(i), right.get(size-i));
		}
		return count;
	}

	private int max(int x, int y) {
		return x > y ? x : y;
	}

}
