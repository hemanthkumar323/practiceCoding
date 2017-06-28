package com.coding.practice.arrays;

import java.util.ArrayList;
import java.util.Collections;

import com.coding.practice.util.Utils;

public class WaveArray {
	
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
		ArrayList<Integer> output = a;
		if(a == null)
			return output;
		int size = a.size();
		Collections.sort(output);
		int nextOpIsGreaterThan = 1; 
		for(int i=1; i< size; i++) {
			if(nextOpIsGreaterThan == 1) {
				if(output.get(i-1) < output.get(i)) {
					int temp = output.get(i-1);
					output.set(i-1, output.get(i));
					output.set(i, temp);
				}
				nextOpIsGreaterThan = 1 - nextOpIsGreaterThan;
			} else {
				if(output.get(i-1) > output.get(i)) {
					int temp = output.get(i-1);
					output.set(i-1, output.get(i));
					output.set(i, temp);
				}
				nextOpIsGreaterThan = 1 - nextOpIsGreaterThan;
			}
			
		}
		return output;
	}
	
	public static void main(String args[]) {
		int arr[] = {3,5,2,4};
		WaveArray w = new WaveArray();
		System.out.println(w.wave((ArrayList<Integer>)Utils.getListFromArray(arr)));
	}

}
