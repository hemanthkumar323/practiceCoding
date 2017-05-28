package com.coding.pratice.sorting;

public class QuickSort {

	public void sort(int arr[], int start, int end) {
		if (start < end) {
			int mid = partition1(arr, start, end);
			sort(arr, start, mid-1);
			sort(arr, mid+1, end);
		}
	}
	
	int partition1(int arr[], int start, int end) {
		int pivot = arr[end];
		int left = start;
		int right = end-1;
		while(left<=right) {
			while(left<=right && arr[left]<pivot) {
				left++;
			}
			while(left<=right && arr[right]>pivot)
				right--;
			if(left<right) {
				swap(arr, left++, right--);
			}
		}
		if(left<end) {
			swap(arr, left, end);
		}
		return left;
	}
	
	 int partition(int arr[], int start, int end)
	 {
	     int pivot = arr[end];
	     int i = start; // index of smaller element
	     for (int j=start; j<end; j++)
	     {
	         // If current element is smaller than or
	         // equal to pivot
	         if (arr[j] <= pivot)
	         {	            
	             if(i!=j) {
	            	 swap(arr, i, j);
	             }
	             i++;
	         }
	     }
	    swap(arr, i, end);
	     return i;
	 }
	
	private void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

}
