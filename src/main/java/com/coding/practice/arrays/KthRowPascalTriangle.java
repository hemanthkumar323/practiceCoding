package com.coding.practice.arrays;

import java.util.ArrayList;

public class KthRowPascalTriangle {
	
	public ArrayList<Integer> generate(int a) {

		ArrayList<Integer> prev = null;
		for (int i = 0; i <= a; i++) {
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
		}

		return prev;
	}
	
	
	public static void main(String args[]) {
		KthRowPascalTriangle triangle = new KthRowPascalTriangle();
		System.out.println(triangle.generate(3));
	}

}
