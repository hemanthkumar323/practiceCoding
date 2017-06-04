package com.coding.practice.arrays;

public class FindTwoNumbersEqualToX {
	
	// Assumption - sorted array
	public void process(int arr[], int sum) {
		int len = arr.length;
		int i=0,j=len-1;
		while(i<j) {
			int temp = arr[i] + arr[j];
			if(temp == sum) {
				System.out.println(arr[i]);
				System.out.println(arr[j]);
				return;
				
			} else if(temp > sum) {
				j--;
			} else {
				i++;
			}
		}
		
		System.out.println("No such numbers are found with sum = "+ sum);
	}
	
	public static void main(String args[]) {
		int arr[] = {1,3,4,5,7,9};
		FindTwoNumbersEqualToX x = new FindTwoNumbersEqualToX();
		x.process(arr, 10);
		x.process(arr, 16);
		x.process(arr, 12);
		x.process(arr, 22);
	}

}
