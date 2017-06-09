package com.coding.practice.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.coding.practice.util.Utils;

public class SlidingWindowMax {

	public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
		Deque<Integer> deque = new LinkedList<Integer>();
		ArrayList<Integer> output = new ArrayList<Integer>();
		int size = a.size();
		int i = 1;
		while (i <= size) {
			while (!deque.isEmpty() && a.get(deque.peekLast() - 1) < a.get(i - 1))
				deque.removeLast();
			deque.add(i);

			if (i >= b) {
				output.add(a.get(deque.getFirst()-1));
			}
			while (!deque.isEmpty() && deque.peekFirst() <= i - b + 1 )
				deque.removeFirst();
			i++;

		}
		if(b > size) {
			if(!deque.isEmpty())
				output.add(a.get(deque.getFirst()-1));
		}
		return output;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int arr1[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		SlidingWindowMax histogram = new SlidingWindowMax();
		System.out.println(histogram.slidingMaximum(Utils.getListFromArray(arr), 3));
	}

}
