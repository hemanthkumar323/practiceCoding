package com.coding.practice.arrays;

import java.util.ArrayList;
import java.util.Iterator;

import com.coding.practice.sorting.HeapSortWithArrayList;

public class PIntegersGreaterThanP {
	private final HeapSortWithArrayList hSort = new HeapSortWithArrayList();
	
	 public int solve(ArrayList<Integer> A) {
		 int size = A.size();
		 hSort.sort(A, size);
		 for(int ind=0; ind<size; ind++) {
			 if((ind==size-1 || A.get(ind) != A.get(ind+1))&& A.get(ind) == size-ind-1) {
				 return 1;
			 }
		 }
		 return -1;
		 
	 }
	
}
