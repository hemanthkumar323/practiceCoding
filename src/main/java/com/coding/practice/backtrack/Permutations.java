package com.coding.practice.backtrack;

import java.util.ArrayList;

import com.coding.practice.util.Utils;

public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		if (a == null)
			return new ArrayList<ArrayList<Integer>>();
		int size = a.size();
		return permuteUtil(a, 0, size - 1);
	}

	private ArrayList<ArrayList<Integer>> permuteUtil(ArrayList<Integer> list, int start, int end) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		if (start == end) {
			output.add(new ArrayList<Integer>(list));
			return output;
		}
		for (int i = start; i <= end; i++) {
			// swap start, i
			int temp = list.get(start);
			list.set(start, list.get(i));
			list.set(i, temp);

			ArrayList<ArrayList<Integer>> intermediateOutput = permuteUtil(list, start + 1, end);
			output.addAll(intermediateOutput);

			temp = list.get(start);
			list.set(start, list.get(i));
			list.set(i, temp);

		}

		return output;

	}

	public static void main(String args[]) {
		int arr[] = { 7, 3, 2 };
		Permutations s = new Permutations();
		System.out.println(s.permute((ArrayList<Integer>) Utils.getListFromArray(arr)));
	}
}
