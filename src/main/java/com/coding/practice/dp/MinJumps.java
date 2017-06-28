package com.coding.practice.dp;

import java.util.ArrayList;

import com.coding.practice.util.Utils;

public class MinJumps {
	public int jump(ArrayList<Integer> arr) {
		int length = arr.size();
		if (length <= 1)
			return 0;

		// Return -1 if not possible to jump
		if (arr.get(0) == 0)
			return -1;

		// initialization
		int maxReach = arr.get(0);
		int step = maxReach;
		int jump = 1;

		// Start traversing array
		for (int i = 1; i < length; i++) {
			// Check if we have reached the end of the array
			if (i == length - 1)
				return jump;

			// updating maxReach
			maxReach = Math.max(maxReach, i + arr.get(i));

			// we use a step to get to the current index
			step--;

			// If no further steps left
			if (step == 0) {
				// we must have used a jump
				jump++;

				// Check if the current index/position or lesser index
				// is the maximum reach point from the previous indexes
				if (i >= maxReach)
					return -1;

				// re-initialize the steps to the amount
				// of steps to reach maxReach from position i.
				step = maxReach - i;
			}
		}

		return -1;
	}

	public int jump1(ArrayList<Integer> a) {
		if (a == null)
			return -1;

		ArrayList<Integer> dp = new ArrayList<Integer>();
		dp.add(0);
		int length = a.size();

		for (int i = 0; i < length - 1; i++) {
			if (dp.size() > i) {
				int ele = a.get(i);
				int minLen = min(i + ele, length - 1);
				for (int j = i + 1; j <= minLen; j++) {
					if (dp.size() > j) {
						int existingJumpCount = dp.get(j);
						dp.set(j, min(existingJumpCount, dp.get(i) + 1));
					} else {
						dp.add(dp.get(i) + 1);
					}

				}
			}
		}
		System.out.println(dp);
		if (dp.size() == length)
			return dp.get(length - 1);
		return -1;

	}

	int minJumps(int arr[]) {
		if (arr.length <= 1)
			return 0;

		// Return -1 if not possible to jump
		if (arr[0] == 0)
			return -1;

		// initialization
		int maxReach = arr[0];
		int step = arr[0];
		int jump = 1;

		// Start traversing array
		for (int i = 1; i < arr.length; i++) {
			// Check if we have reached the end of the array
			if (i == arr.length - 1)
				return jump;

			// updating maxReach
			maxReach = Math.max(maxReach, i + arr[i]);

			// we use a step to get to the current index
			step--;

			// If no further steps left
			if (step == 0) {
				// we must have used a jump
				jump++;

				// Check if the current index/position or lesser index
				// is the maximum reach point from the previous indexes
				if (i >= maxReach)
					return -1;

				// re-initialize the steps to the amount
				// of steps to reach maxReach from position i.
				step = maxReach - i;
			}
		}

		return -1;
	}

	private int min(int x, int y) {
		return x < y ? x : y;
	}

	public static void main(String args[]) {
		int arr[] = { 33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34,
				0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36,
				18, 33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10,
				23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28 };
		MinJumps j = new MinJumps();
		//System.out.println(j.jump((ArrayList<Integer>) Utils.getListFromArray(arr)));
		System.out.println(j.minJumps(arr));
	}
}
