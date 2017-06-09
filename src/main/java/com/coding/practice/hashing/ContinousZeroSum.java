package com.coding.practice.hashing;

import java.util.ArrayList;
import java.util.HashMap;

import com.coding.practice.util.Utils;

public class ContinousZeroSum {

	public ArrayList<Integer> lszero(ArrayList<Integer> a) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int size = a.size();
		int sum = 0;
		int startIndex = -1, endIndex = -1;
		for(int i = 0; i< size; i++) {
			sum = sum + a.get(i);
			if(sum == 0) {
				startIndex = 0;
				endIndex = i;
			} else {
				if(map.containsKey(sum)) {
					if(startIndex==-1 || (i - map.get(sum) - 1 > endIndex - startIndex)) {
						startIndex = map.get(sum) + 1;
						endIndex = i;	
					}
					
				} else {
					map.put(sum, i);
				}
			}
			
		}
		
		for(int i= startIndex; i<= endIndex; i++) {
			output.add(a.get(i));
		}
		return output;
	}

	public static void main(String args[]) {
		int arr[] = { 2, 1, -3, 3 };
		ContinousZeroSum sum = new ContinousZeroSum();
		System.out.println(sum.lszero((ArrayList<Integer>)Utils.getListFromArray(arr)));

	}

}
