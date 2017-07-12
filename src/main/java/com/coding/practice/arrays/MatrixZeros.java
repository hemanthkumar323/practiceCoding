package com.coding.practice.arrays;

import java.util.ArrayList;

import com.coding.practice.util.Utils;

public class MatrixZeros {

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		if (a == null)
			return;
		int rows = a.size();
		int cols = a.get(0).size();
		boolean isFirstRowSet = false, isFirstColSet = false;

		for (int i = 0; i < rows; i++) {
			if (a.get(i).get(0) == 0) {
				isFirstColSet = true;
				break;
			}
		}

		for (int i = 0; i < cols; i++) {
			if (a.get(0).get(i) == 0) {
				isFirstRowSet = true;
				break;
			}
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (a.get(i).get(j) == 0) {
					a.get(i).set(0, 0);
					a.get(0).set(j, 0);
				}
			}
		}

		for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if(i==0) {
						if(isFirstRowSet)
							a.get(0).set(j, 0);
					}
					else if(j==0) {
						if(isFirstColSet)
							a.get(i).set(0, 0);
					}
					else if (a.get(i).get(0) == 0 || a.get(0).get(j) == 0) {
						a.get(i).set(j, 0);
				}
			}
		}
		
		if(isFirstRowSet) {
			for(int i=0; i<cols; i++) {
				a.get(0).set(i, 0);
			}
		}
		
		if(isFirstColSet) {
			for(int i=0; i<rows; i++) {
				a.get(i).set(0, 0);
			}
		}
	}

	private void print(ArrayList<ArrayList<Integer>> a) {
		int rows = a.size();
		int cols = a.get(0).size();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(a.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		int arr1[] = {1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0};
		int arr2[] = {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int arr3[] = {0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		
		int arr4[] = {0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1};
		int arr5[] = {0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1};
		int arr6[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1};
		
		int arr7[] = {0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1};
		int arr8[] = {0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1};
		int arr9[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1};
		
		
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		input.add((ArrayList<Integer>)Utils.getListFromArray(arr1));
		input.add((ArrayList<Integer>)Utils.getListFromArray(arr2));
		input.add((ArrayList<Integer>)Utils.getListFromArray(arr3));
		MatrixZeros m = new MatrixZeros();
		m.setZeroes(input);
		m.print(input);
	}
}
