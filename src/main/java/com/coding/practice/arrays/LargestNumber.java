package com.coding.practice.arrays;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import com.coding.practice.util.Utils;

/**
 * 
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example:
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * @author Hemanth
 *
 */
public class LargestNumber {
	
	class MyComparator implements Comparator<Integer> {
		public int compare(Integer x, Integer y) {
			String str1 = ""+x+y;
			String str2 = ""+y+x;
			if(Integer.parseInt(str1) > Integer.parseInt(str2))
				return 1;
			return -1;
		}
	}

	public String largestNumber(final List<Integer> a) {
		Collections.sort(a, new MyComparator());
		int size = a.size();
		if(a.get(size-1) == 0)
			return "0";
		String output = "";
		for(int i=size-1; i>=0; i--) {
			output = output + a.get(i);
		}
		return output;
	}
	
	public static void main(String args[]) {
		int arr[] = {0,0,1};
		List<Integer> list = Utils.getListFromArray(arr);
		LargestNumber l = new LargestNumber();
		System.out.println(l.largestNumber(list));
		Utils.printList(list);
		
	}
}
