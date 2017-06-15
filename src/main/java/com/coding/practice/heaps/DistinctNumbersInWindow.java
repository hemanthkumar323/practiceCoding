package com.coding.practice.heaps;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctNumbersInWindow {

	public ArrayList<Integer> dNums(ArrayList<Integer> A, int windowSize) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int current_count = 0;
		if(A == null || A.size() == 0)
			return output;
		int size = A.size();
		int min_window_size = min(windowSize, size);
		// Populate map for first window
		for(int i=0; i<min_window_size; i++) {
			int ele = A.get(i);
			if(map.containsKey(ele)) {
				int ele_count = map.get(ele);
				map.put(ele, ele_count + 1);
			} else {
				map.put(ele, 1);
				current_count++;
			}
		}
		output.add(current_count);
		for(int i=min_window_size; i < size; i++) {
			int eleToRemove = A.get(i - windowSize);
			if(map.get(eleToRemove) == 1) {
				map.remove(eleToRemove);
				current_count --;
			} else {
				int temp_count = map.get(eleToRemove);
				map.put(eleToRemove, temp_count-1);
			}
			
			int ele = A.get(i);
			if(map.containsKey(ele)) {
				int ele_count = map.get(ele);
				map.put(ele, ele_count + 1);
			} else {
				map.put(ele, 1);
				current_count++;
			}
			output.add(current_count);
		}
		return output;
	}
	
	private int min(int x, int y) {
		return x > y ? y : x;
	}

}
