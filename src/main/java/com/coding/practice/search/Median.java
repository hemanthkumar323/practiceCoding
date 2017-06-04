package com.coding.practice.search;

import java.util.ArrayList;

import com.coding.practice.util.Utils;

/**
 * Given a N cross M matrix in which each row is sorted, find the overall median 
 * of the matrix. Assume N*M is odd.
 * @author Hemanth
 *
 */
public class Median {
	
	public int findMedian(ArrayList<ArrayList<Integer>> A) {
		int rows = A.size();
		int cols = A.get(0).size();
		
		int min = A.get(0).get(0);
		int max = A.get(0).get(0);
		
		for(int i=0; i<rows; i++) {
			for(int j=0;j<cols;j++) {
				int temp = A.get(i).get(j);
				if(min > temp) {
					min = temp;
				}
				if(max < temp) {
					max = temp;
				}
			}
		}
		int midElementCount = 1+ (rows*cols)/2;
		while(min<max) {
			int count = 0;
			int mid = min + (max - min)/2;
			for(int i=0; i<rows; i++) {
				count = count + bsearch(A.get(i), mid);
			}
			//System.out.println("mid= "+ mid+ " count= "+ count);
			if(count < midElementCount)
				min = mid+1;
			else
				max = mid;
		}
		return min;
    }
	
	public int bsearch(ArrayList<Integer> arr, int key) {
		return search(arr, 0, arr.size()-1, key);
	}
	
	public int search(ArrayList<Integer> arr, int start, int end, int key) {
		if(start>end) {
			return 0;
		}
		int mid = start + (end-start)/2;
		if(arr.get(mid) > key && (mid-1<start || arr.get(mid-1) <= key)) {
			return mid;
		}
			
		if(mid== arr.size()-1) {
			return mid+1;
		}
		
		if(arr.get(mid)>key) {
			return search(arr, start, mid-1, key);
		} 
		return search(arr, mid+1, end, key);
			
	}
	
	public static void main(String args[]) {
		int arr1[] = {1,4,7};
		int arr2[] = {4,10,11};
		int arr3[] = {10,11,12};
		ArrayList<Integer> temp1 = (ArrayList<Integer>)Utils.getListFromArray(arr1);
		ArrayList<Integer> temp2 = (ArrayList<Integer>)Utils.getListFromArray(arr2);
		ArrayList<Integer> temp3 = (ArrayList<Integer>)Utils.getListFromArray(arr3);
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		arr.add(temp1);
		arr.add(temp2);
		arr.add(temp3);
		Median median = new Median();
		System.out.println(median.findMedian(arr));
	}
}
