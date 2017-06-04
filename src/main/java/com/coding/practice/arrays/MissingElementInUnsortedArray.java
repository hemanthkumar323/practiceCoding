package com.coding.practice.arrays;

import java.util.ArrayList;

/**
 * Question - 
 * Given an unsorted integer array, find the first missing positive integer.
 * Example:
 * Given [1,2,0] return 3,
 * [3,4,-1,1] return 2,
 * [-8, -7, -6] returns 1
 * Your algorithm should run in O(n) time and use constant space.
 * 
 * 
 * Procedure -
 * 1. Divide the array where we move all non-positive integers to left and positive integers to right
 * 2. Then mark all non-positive integers and zeros as +ve
 * 3. traverse the array from index that contains positive integers and mark that specific index as -ve
 * 4. Now, finally traverse the array from index 1 and return the first index as output that contains as positive. 
 * (Since if that element is present in array then, it should have been -ve)
 * 
 * @author Hemanth
 *
 */

public class MissingElementInUnsortedArray {
	
	// With ArrayList as input
	public int firstMissingPositive(ArrayList<Integer> a) {
		int startIndexOfPosNum = divideArray(a);
		int size = a.size();
		for(int i=0;i<startIndexOfPosNum;i++) {
			a.set(i, Math.abs(a.get(i)));
			if(a.get(i) == 0)
				a.set(i,1);
		}
		for(int i=startIndexOfPosNum; i<size; i++) {
			int temp = Math.abs(a.get(i));
			if(temp<size) {
				a.set(temp, Math.abs(a.get(temp)) * -1);
			}
		}
		int result = 0;
		for(int i=1;i<size;i++) {
			if(a.get(i) > 0) {
				result = i;
				break;
			}
		}
		return result==0 ? size-startIndexOfPosNum+1 : result;
	}
	
	public int divideArray(ArrayList<Integer> a) {
		int size = a.size();
		int i=0, j= size-1;
		while(i<=j) {
			while(i<=j && a.get(i)<=0) {
				i++;
			}
			while(i<=j && a.get(j)>0) {
				j--;
			}
			if(i<j) {
				swap(a, i++, j--);
			}
		}
		return i;
	}
	
	public void swap(ArrayList<Integer> arr, int i, int j) {
		int temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	
	// With Array as input
	public int divideArray(int a[]) {
		int size = a.length;
		int i=0, j= size-1;
		while(i<=j) {
			while(i<=j && a[i]<=0) {
				i++;
			}
			while(i<=j && a[j]>0) {
				j--;
			}
			if(i<j) {
				swap(a, i++, j--);
			}
		}
		return i;
	}
	
	public int findMissingPositive(int arr[], int startIndexOfPosNum) {
		int size = arr.length;
		// remove all zeros
		for(int i=0;i<startIndexOfPosNum;i++) {
			arr[i] = Math.abs(arr[i]);
			if(arr[i] == 0)
				arr[i] = 1;
		}
		for(int i=startIndexOfPosNum; i<size; i++) {
			int temp = Math.abs(arr[i]);
			if(temp<size) {
				arr[temp] = Math.abs(arr[temp]) * -1;
			}
		}
		int result = 0;
		for(int i=1;i<size;i++) {
			if(arr[i] > 0) {
				result = i;
				break;
			}
		}
		return result==0 ? size-startIndexOfPosNum+1 : result;
	}
	
	public void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String args[]) {
		int arr[] = {-1,-2,0,1,3};
		MissingElementInUnsortedArray triangle = new MissingElementInUnsortedArray();
		int temp=triangle.divideArray(arr);
		
		for(int i=0; i<arr.length;i++)
			System.out.println(arr[i]);
		System.out.println(triangle.findMissingPositive(arr,temp));
	}

}
