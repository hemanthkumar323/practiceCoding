package com.coding.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.coding.practice.util.Utils;

public class Anagrams {
	
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		ArrayList<String> stringOrder = new ArrayList<String>();
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		
		int size = a.size();
		for(int i = 1; i<=size; i++) {
			String temp = sortChars(a.get(i-1));
			if(map.containsKey(temp)) {
				ArrayList<Integer> list = map.get(temp);
				list.add(i);
				map.put(temp, list);
			} else {
				stringOrder.add(temp);
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(temp, list);
			}
		}
		
		size = stringOrder.size();
		for(int i=0; i< size; i++) {
			output.add(map.get(stringOrder.get(i)));
		}
		
		return output;
	}
	
	private String sortChars(String str) {
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);
		return new String(charArr);
	}
	
	public static void main(String args[]) {
		String a[] = {"cat", "dog", "god", "tca"};
		Anagrams anagrams = new Anagrams();
		System.out.println(anagrams.anagrams(Utils.getStringListFromArray(a)));
	}

}
