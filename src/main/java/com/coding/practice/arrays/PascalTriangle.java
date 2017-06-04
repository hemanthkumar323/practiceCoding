package com.coding.practice.arrays;

import java.util.ArrayList;

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int a) {

		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> prev = null;
		for (int i = 0; i < a; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			if (i > 0) {
				temp.add(1);

				int size = prev.size();
				for (int ind = 0; ind < size - 1; ind++) {
					temp.add(prev.get(ind) + prev.get(ind + 1));
				}
			}

			temp.add(1);
			prev = temp;

			output.add(temp);

		}

		return output;
	}

	public static void main(String args[]) {
		PascalTriangle triangle = new PascalTriangle();
		System.out.println(triangle.generate(5));
	}
}