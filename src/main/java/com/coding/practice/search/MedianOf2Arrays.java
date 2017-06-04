package com.coding.practice.search;

import java.util.List;

import com.coding.practice.util.Utils;

public class MedianOf2Arrays {
	
	// Assumption - arrays are sorted
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		int size1 = a.size();
		int size2 = b.size();
		int total_size = size1 + size2;
		int nBy2Ele = Integer.MIN_VALUE;
		int nBy2Plus1Ele = Integer.MAX_VALUE;
		int a_index = 0, b_index = 0, currentIndex = 0;
		int mid = total_size/2;
		while((a_index < size1 || b_index < size2) && currentIndex < mid+1) {
			
			int a_ele = (a_index < size1) ? a.get(a_index) : Integer.MAX_VALUE;
			int b_ele = (b_index < size2) ? b.get(b_index) : Integer.MAX_VALUE;
			
			if(a_ele < b_ele)
				a_index++;
			else
				b_index++;
			currentIndex++;
			
			if(currentIndex == mid) {
				nBy2Ele = (a_ele < b_ele) ? a_ele : b_ele;
			}
			if(currentIndex == mid+1) 
				nBy2Plus1Ele = (a_ele < b_ele) ? a_ele : b_ele;
		}
		
		
		if(total_size%2==0) 
			return (double)(nBy2Ele + nBy2Plus1Ele)/2;
		return nBy2Plus1Ele;
	}
	
	public static void main(String args[]) {
		int arr1[] = {1,4,5,7};
		int arr2[] = {2,3};
		List<Integer> list1 = Utils.getListFromArray(arr1);
		List<Integer> list2 = Utils.getListFromArray(arr2);
		MedianOf2Arrays med = new MedianOf2Arrays();
		System.out.println(med.findMedianSortedArrays(list1, list2));
		
		
	}

}
