package com.coding.practice.greedy;

import java.util.ArrayList;

public class Product {

	public int maxp3(ArrayList<Integer> a) {
		int size = a.size();
		int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;
		int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			int temp = a.get(i);
			// Update Maximum, second maximum and third
			// maximum element
			if (temp > maxA) {
				maxC = maxB;
				maxB = maxA;
				maxA = temp;
			}

			// Update second maximum and third maximum element
			else if (temp > maxB) {
				maxC = maxB;
				maxB = temp;
			}

			// Update third maximum element
			else if (temp > maxC)
				maxC = temp;

			// Update Minimum and second mimimum element
			if (temp < minA) {
				minB = minA;
				minA = temp;
			}

			// Update second mimimum element
			else if (temp < minB)
				minB = temp;
		}

		return max(minA * minB * maxA, maxA * maxB * maxC);

	}

	private int max(int x, int y) {
		return x > y ? x : y;
	}

}
