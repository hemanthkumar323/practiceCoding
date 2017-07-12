package com.coding.practice.arrays;

import java.util.ArrayList;

import com.coding.practice.util.Utils;

public class NextPermutation {

	public void nextPermutation(ArrayList<Integer> a) {
		int len = a.size();

		int start = -1;
		for (int i = len - 2; i >= 0; i--) {
			if (a.get(i+1) > a.get(i)) {
				start = i;
				break;
			}
		}

		// reverse from start to len-1;
		if (start != -1) {
			
			int l = -1;
	    	for (int i = len - 1; i > start; i--) {
	    		if (a.get(i) > a.get(start)) {
	    			l = i;
	    			break;
	    		} 
	    	} 
	    	swap(a, start, l);
	    	reverse(a, start + 1, len-1); 
	    	
		} else {
			reverse(a, 0, len-1);
		}
	}
	
	private void reverse(ArrayList<Integer> a, int start, int end) {
		while (start < end) {
			int temp = a.get(end);
			a.set(end, a.get(start));
			a.set(start, temp);
			start++;
			end--;
		}
	}
	
	private void swap(ArrayList<Integer> a, int i, int j) {
		int temp = a.get(j);
		a.set(j, a.get(i));
		a.set(i, temp);
	}

	private void print(ArrayList<Integer> a) {
		int rows = a.size();
		for (int i = 0; i < rows; i++) {
			System.out.println(a.get(i));
		}
	}

	public static void main(String args[]) {
		int arr[] = { 319, 695, 52 };
		ArrayList<Integer> list = (ArrayList<Integer>) Utils.getListFromArray(arr);
		NextPermutation n = new NextPermutation();
		n.nextPermutation(list);
		n.print(list);
	}

}
