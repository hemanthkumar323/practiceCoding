package com.coding.practice.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;

import com.coding.practice.util.Utils;

/**
 * https://www.interviewbit.com/problems/combination-sum/
 * @author Hemanth
 *
 */
public class CombinationSum {
	
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
		if(a == null)
			return new ArrayList<ArrayList<Integer>>();
		a = new ArrayList<Integer>(new LinkedHashSet<Integer>(a));
		Collections.sort(a);
		int size = a.size();
		return combinationSumUtil(a, b, 0, size-1, new ArrayList<Integer>());
		
	}
	
	public ArrayList<ArrayList<Integer>> combinationSumUtil(ArrayList<Integer> sortedList, int b, int start, int end, ArrayList<Integer> temp) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		if(b == 0) {
			output.add(temp);
			return output;
		}
		for(int i=start; i<=end; i++) {
			if(b == sortedList.get(i)) {
				ArrayList<Integer> res = new ArrayList<Integer>(temp);
				res.add(sortedList.get(i));
				output.add(res);
				return output;
			} else if(b> sortedList.get(i)) {
				ArrayList<Integer> res = new ArrayList<Integer>(temp);
				res.add(sortedList.get(i));
				ArrayList<ArrayList<Integer>> listWithI = combinationSumUtil(sortedList, b-sortedList.get(i), i, end, res);
				output.addAll(listWithI);
			}
		}
		return output;
	}
	
	public static void main(String args[]) {
		int arr[] ={7,3,2};
		CombinationSum sum = new CombinationSum();
		System.out.println(sum.combinationSum((ArrayList<Integer>)Utils.getListFromArray(arr), 7));
		
		
	}

}
