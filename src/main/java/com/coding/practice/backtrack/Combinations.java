package com.coding.practice.backtrack;

import java.util.ArrayList;

public class Combinations {

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		if (n >= 1 && k >= 1 && n >= k) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			return combineUtil(1, n, k, n, temp);

		}
		return output;
	}

	public ArrayList<ArrayList<Integer>> combineUtil(int start, int end, int k, int n, ArrayList<Integer> list) {
		ArrayList<ArrayList<Integer>> outputList = new ArrayList<ArrayList<Integer>>();
		if (k == 1) {
			for (int i = start; i <= n; i++) {
				ArrayList<Integer> listTemp = new ArrayList<Integer>(list);
				listTemp.add(i);
				outputList.add(listTemp);
			}
		} else {
			for (int i = start; i <= end; i++) {
				ArrayList<Integer> listTemp =  new ArrayList<Integer>(list);;
				listTemp.add(i);
				ArrayList<ArrayList<Integer>> temp1 = combineUtil(i + 1, end, k - 1, n, listTemp);
				int size = temp1.size();
				for (int j = 0; j < size; j++)
					outputList.add(temp1.get(j));

			}
		}
		return outputList;
	}

	public static void main(String args[]) {
		Combinations com = new Combinations();
		System.out.println(com.combine(4,2));
	}

}
