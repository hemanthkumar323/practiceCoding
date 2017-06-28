package com.coding.practice.arrays;

import java.util.ArrayList;
import java.util.List;

import com.coding.practice.util.Utils;

/**
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 * 
 * @author Hemanth
 *
 */
public class RepeatAndMissingNumber {

	public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		if (a == null)
			return output;
		int size = a.size();
		int xor = 0;
		for (int i = 1; i <= size; i++) {
			xor = xor ^ i;
		}

		for (int i = 0; i < size; i++) {
			xor = xor ^ a.get(i);
		}
		int set_bit_no = xor & ~(xor - 1);
		int num1 = 0, num2 = 0;
		for (int i = 0; i < size; i++) {
			if ((set_bit_no & a.get(i)) == 0) {
				num1 = num1 ^ a.get(i);
			} else {
				num2 = num2 ^ a.get(i);
			}
		}
		for (int i = 1; i <= size; i++) {
			if ((set_bit_no & i) == 0)
				num1 = num1 ^ i;
			else
				num2 = num2 ^ i;
		}
		
		int count_of_num1 = 0;
		for(int i=0; i<size; i++) {
			if(a.get(i) == num1)
				count_of_num1++;
		}
		
		if(count_of_num1 == 2) {
			output.add(num1);
			output.add(num2);
		} else {
			output.add(num2);
			output.add(num1);
		}
		return output;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 5, 3 };
		RepeatAndMissingNumber x = new RepeatAndMissingNumber();
		System.out.println(x.repeatedNumber(Utils.getListFromArray(arr)));
	}

}
