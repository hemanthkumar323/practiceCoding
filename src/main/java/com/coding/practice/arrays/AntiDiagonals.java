package com.coding.practice.arrays;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/anti-diagonals/
 * @author Hemanth
 *
 */
public class AntiDiagonals {
	
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		if(a == null)
			return output;
		int size = a.size();
		int totalSizeOfOutput = 2*size - 1;
		for(int i=0; i<totalSizeOfOutput; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			int j_size = Math.min(i, size-1);
			for(int j=0; j<=j_size; j++) {
				for(int k=i-j; k<size; k++) {
					if(j+k == i) {
						temp.add(a.get(j).get(k));
					}
				}
			}
			output.add(temp);
		}
		return output;
	}

}
