package com.coding.practice.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coding.practice.util.Utils;

/**
 * https://www.interviewbit.com/problems/longest-arithmetic-progression/
 * 
 * @author Hemanth
 *
 */
public class LongestArithmeticProgression {

	public int solve(final List<Integer> A) {
		if (A == null || A.size() == 0)
			return 0;
		int size = A.size();
		if (size <= 2) {
			return size;
		}
		int result = 1;
		Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
		map.put(0, new HashMap<Integer, Integer>());
		for (int i = 1; i < size; i++) {
			// Contains diff to count map
			Map<Integer, Integer> diffToCountMap = new HashMap<Integer, Integer>();
			for (int j = 0; j < i; j++) {
				int diff = A.get(i) - A.get(j);
				Map<Integer, Integer> mapForJthelement = map.get(j);
				int countForJthEle = 0;
				if (mapForJthelement != null && mapForJthelement.get(diff) != null)
					countForJthEle = mapForJthelement.get(diff);
				int countForIthEle = 2;
				if (diffToCountMap.get(diff) != null) {
					countForIthEle = diffToCountMap.get(diff) + 1;
				}
				int countToInsert = Math.max(countForIthEle, countForJthEle + 1);
				diffToCountMap.put(diff, countToInsert);
				result = Math.max(result, countToInsert);

			}
			map.put(i, diffToCountMap);
		}

		return result;

	}

	public static void main(String args[]) {
		int arr[] = { 7,7,7 };
		LongestArithmeticProgression p = new LongestArithmeticProgression();
		System.out.println(p.solve(Utils.getListFromArray(arr)));
	}

}
