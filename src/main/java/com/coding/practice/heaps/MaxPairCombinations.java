package com.coding.practice.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

import com.coding.practice.util.Utils;

/**
 * https://www.interviewbit.com/problems/n-max-pair-combinations/
 * 
 * @author Hemanth
 *
 */
public class MaxPairCombinations {

	class Pair {
		int first, second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
		public boolean equals(Object obj){
	        if (obj instanceof Pair) {
	        	Pair pair = (Pair) obj;
	            return (this.first == pair.first && this.second == pair.second);
	        } else {
	            return false;
	        }
	    }
	}

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		int size = A.size();
		Map<Pair, Pair> map = new HashMap<Pair, Pair>();
		ArrayList<Pair> heap = new ArrayList<Pair>();
		ArrayList<Integer> output = new ArrayList<Integer>();
		Collections.sort(A);
		Collections.sort(B);

		Pair pair = new Pair(size - 1, size - 1);
		heap.add(pair);
		map.put(pair, pair);
		int k = size;
		while (k > 0) {
			Pair top = heap.get(0);
			heap.remove(0);
			int left = top.first;
			int right = top.second;
			output.add(A.get(left) + B.get(right));
			
			pair = new Pair(left, right-1);
			if(right > 0 && left >= 0 && map.get(pair) != null) {
				heap.add(pair);
			}
			
			pair = new Pair(left-1, right);
			if(right >= 0 && left > 0 && map.get(pair) != null) {
				heap.add(pair);
			}
			k--;
		}

		return output;
	}

	public ArrayList<Integer> solve1(ArrayList<Integer> A, ArrayList<Integer> B) {
		int size = A.size();
		ArrayList<Integer> heap = new ArrayList<Integer>();
		Collections.sort(A, Collections.reverseOrder());
		Collections.sort(B, Collections.reverseOrder());
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				insertToHeap(heap, size, A.get(i) + B.get(j));
			}
		}
		Collections.sort(heap, Collections.reverseOrder());

		return heap;
	}

	private void insertToHeap(ArrayList<Integer> heap, int size, int ele) {
		int current_size = heap.size();
		if (current_size == 0) {
			heap.add(ele);
			return;
		}
		// int parent = (current_size-1)/2;
		if (current_size == size) {
			if (heap.get(0) < ele) {
				heap.remove(0);
				heap.add(0, ele);
				// Collections.sort(heap, Collections.reverseOrder());
				minHeap(heap, 0, size);
			}

		} else {
			heap.add(ele);
			if (current_size == size - 1)
				constructMinHeap(heap);
		}
	}

	private void constructMinHeap(ArrayList<Integer> heap) {
		int size = heap.size();
		for (int i = (size - 1) / 2; i >= 0; i--)
			minHeap(heap, i, size);
	}

	private void minHeap(ArrayList<Integer> heap, int ind, int size) {
		int left = 2 * ind + 1;
		int right = left + 1;
		int minIndex = ind;
		int pivot = heap.get(ind);
		if (left < size && pivot > heap.get(left))
			minIndex = left;
		if (right < size && heap.get(minIndex) > heap.get(right))
			minIndex = right;
		if (minIndex != ind) {
			int temp = heap.get(minIndex);
			heap.set(minIndex, heap.get(ind));
			heap.set(ind, temp);

			minHeap(heap, minIndex, size);
		}
	}

	public static void main(String args[]) {
		int arr1[] = { 1, 2, 3, 4 };
		int arr2[] = { 1, 2, 5, 6 };
		int a[] = { 35, -38, -41, -1, -50, -46, 7, 19, -1, 12, 14, -20, 41, -31, -9, -40, -1, 27, 25, -6, -13, -21, -40,
				-15, -8, 49, 19, -17, -33, 37, 34, 4, 1, -4, -46, 1, 0, -37, 23, 1, 25, -13, -16, -32, 6, 25, -22, -45,
				-46, -47, -48 };
		int b[] = { -9, 35, -38, 26, -23, -39, 48, -37, 30, 35, 47, 36, 39, 45, 40, -10, -5, 6, -37, 47, 33, -48, -19,
				-48, 9, 8, 32, -34, 12, -12, -32, -46, -27, -20, -18, -48, 43, 32, -35, -25, 18, 15, 14, 7, 10, -44, -1,
				-44, 12, -35, 5 };
		MaxPairCombinations x = new MaxPairCombinations();
		System.out.println(x.solve((ArrayList<Integer>) Utils.getListFromArray(arr1),
				(ArrayList<Integer>) Utils.getListFromArray(arr2)));

	}

}
