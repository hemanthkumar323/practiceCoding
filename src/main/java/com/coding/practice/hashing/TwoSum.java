package com.coding.practice.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.coding.practice.util.Utils;

/**
 * https://www.interviewbit.com/problems/2-sum/
 * @author Hemanth
 *
 */
public class TwoSum {

	public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
		int size = a.size();
		ArrayList<Integer> output = new ArrayList<Integer>();
		HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();

		for (int i = 0; i < size; i++) {
			if (map.containsKey(a.get(i))) {
				LinkedList<Integer> list = map.get(a.get(i));
				list.add(i);
				map.put(a.get(i), list);
			} else {
				LinkedList<Integer> list = new LinkedList<Integer>();
				list.add(i);
				map.put(a.get(i), list);
			}
		}

		for (int i = 0; i < size; i++) {
			int currentEle = a.get(i);
			int remainingSum = b - currentEle;
			if (map.containsKey(remainingSum)) {
				LinkedList<Integer> list = map.get(remainingSum);
				int index2 = -1;
				int list_size = list.size();
				for (int j = 0; j < list_size; j++) {
					if (i < list.get(j)) {
						index2 = list.get(j);
						break;
					}
				}

				if (index2 != -1 && (output.size() == 0 || (output.get(1) > index2 + 1)
						|| (output.get(1) == index2 + 1 && output.get(0) > i + 1))) {
					output = new ArrayList<Integer>();
					output.add(i + 1);
					output.add(index2 + 1);
				}
			}
		}

		return output;
	}

	public static void main(String args[]) {
		// int arr[] = {2, 7, 11, 15 };
		int arr[] = { 3, 3, 3 };
		TwoSum twoSum = new TwoSum();
		System.out.println(twoSum.twoSum(Utils.getListFromArray(arr), 6));
	}
}
