package com.coding.practice.stack;

import java.util.ArrayList;
import java.util.Stack;

import com.coding.practice.util.Utils;

public class LargestRectangleInHistogram {

	public int largestRectangleArea(ArrayList<Integer> a) {
		int size = a.size();
		Stack<Integer> st = new Stack<Integer>();
		int i=0;
		int max_area = Integer.MIN_VALUE;
		while(i < size) {
			if(st.isEmpty() || a.get(st.peek()) <= a.get(i)) 
				st.push(i++);
			else {
				int currentEle = st.pop();
				int area_with_top = a.get(currentEle) * (st.isEmpty() ? i : i - st.peek() -1);
				if(max_area < area_with_top)
					max_area = area_with_top;
				
			}
		}
		while(!st.isEmpty()) {
			int currentEle = st.pop();
			int area_with_top = a.get(currentEle) * (st.isEmpty() ? i : i - st.peek() -1);
			if(max_area < area_with_top)
				max_area = area_with_top;
		}
		return max_area;
	}

	public static void main(String args[]) {
		int arr[] = { 2, 1, 5, 6, 2, 3 };
		LargestRectangleInHistogram histogram = new LargestRectangleInHistogram();
		System.out.println(histogram.largestRectangleArea((ArrayList<Integer>) Utils.getListFromArray(arr)));
	}

}
