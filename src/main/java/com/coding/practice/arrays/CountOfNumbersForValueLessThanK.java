package com.coding.practice.arrays;

import java.util.ArrayList;
import java.util.Collections;

import com.coding.practice.util.Utils;

/**
 * https://www.interviewbit.com/problems/numbers-of-length-n-and-value-less-than
 * -k/
 * 
 * @author Hemanth
 *
 */
public class CountOfNumbersForValueLessThanK {

	public int solve(ArrayList<Integer> validNumbers, int digits, int value) {
		if (validNumbers == null)
			return 0;

		int size = validNumbers.size();
		int result = 0;
		for (int i = 0; i < size; i++) {
			int ele = validNumbers.get(i);
			if (ele != 0) {
				if (value - ele > 0) {
					result += count(validNumbers, digits - 1, ele, value);
				}
			} else {
				if(digits == 1)
					result +=1;
			}
		}
		return result;
	}

	private int count(ArrayList<Integer> validNumbers, int digits, int currvalue, int value) {
		if (digits == 0)
			return 1;

		int size = validNumbers.size();
		int result = 0;
		for (int i = 0; i < size; i++) {
			int ele = validNumbers.get(i);

			if (value > currvalue*10 + ele ) {
				result += count(validNumbers, digits - 1, currvalue*10 + ele, value);
			}

		}
		return result;

	}

	public static void main(String args[]) {
		int arr[] = {0,1,5};
		int digits = 1;
		int sum = 2;
		CountOfNumbersForValueLessThanK c = new CountOfNumbersForValueLessThanK();
		System.out.println(c.solve((ArrayList<Integer>) Utils.getListFromArray(arr), digits, sum));
	}
}
