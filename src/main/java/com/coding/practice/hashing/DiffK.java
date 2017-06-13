package com.coding.practice.hashing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.coding.practice.util.Utils;

public class DiffK {
	
	public int diffPossible(final List<Integer> a, int b) {
		int size = a.size();
		if(size < 2)
		    return 0;
		HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
		for(int i=0; i< size; i++) {
			int temp = a.get(i);
			if(map.containsKey(temp)) {
				LinkedList<Integer> list = map.get(temp);
				list.add(i);
				map.put(temp, list);
				
			} else {
				LinkedList<Integer> list = new LinkedList<Integer>();
				list.add(i);
				map.put(temp, list);
			}
		}
		
		for(int i=0; i<size; i++) {
			if(map.containsKey(a.get(i) - b)) {
				LinkedList<Integer> list = map.get(a.get(i) - b);
			    if( list.size() > 1 || list.get(0) !=i)
			    	return 1;
			}
		}
		return 0;
	}
	
	
	public static void main(String args[]) {
		int arr[]= {1, 5, 4, 1, 2};
		DiffK diff = new DiffK();
		System.out.println(diff.diffPossible(Utils.getListFromArray(arr), 0));
	}

}
