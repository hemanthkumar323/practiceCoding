package com.coding.practice.arrays;

// Find any 3 numbers in array equal to input sum in O(n)
public class ThreeNumbersEqualToX {

	// Assumption - sorted array
	public void process(int arr[], int sum) {
		int len = arr.length;
		for(int i=0; i<len-2;i++) {
			int start = i+1;
			int end = len-1;
			
			while(start<end) {
				int temp = arr[i] + arr[start] + arr[end];
				if(temp == sum) {
					System.out.println(arr[i]);
					System.out.println(arr[start]);
					System.out.println(arr[end]);
					return;
				} else if(temp > sum) 
					end--;
				else
					start++;
			}
		}
		System.out.println("No such numbers are found with sum = "+ sum);

	}

	public static void main(String args[]) {
		int arr[] = { 1, 3, 4, 5, 7, 9 };
		ThreeNumbersEqualToX x = new ThreeNumbersEqualToX();
		x.process(arr, 10);
		x.process(arr, 16);
		x.process(arr, 12);
		x.process(arr, 21);
	}

}
