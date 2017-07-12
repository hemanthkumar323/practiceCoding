package com.coding.practice.backtrack;

import java.util.ArrayList;
import java.util.Collections;

import com.coding.practice.util.Utils;

/**
 * https://www.interviewbit.com/problems/subset/
 * 
 * @author Hemanth
 *
 */
public class Subset {

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		if (a == null)
			return output;
		int size = a.size();
		Collections.sort(a);
		return subsetsUtil(a, 0, size - 1, new ArrayList<Integer>());
	}

	private ArrayList<ArrayList<Integer>> subsetsUtil(ArrayList<Integer> list, int start, int end,
			ArrayList<Integer> temp) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		output.add(temp);
		if (start > end) {
			return output;
		}
		for (int i = start; i <= end; i++) {
			ArrayList<Integer> newList = new ArrayList<Integer>(temp);
			newList.add(list.get(i));
			ArrayList<ArrayList<Integer>> intermediateOutput = subsetsUtil(list, i + 1, end, newList);
			output.addAll(intermediateOutput);
		}
		return output;
	}
	
	public static void main(String args[]) {
		int arr[] ={7,3,2};
		Subset s = new Subset();
		System.out.println(s.subsets((ArrayList<Integer>)Utils.getListFromArray(arr)));
	}

}
