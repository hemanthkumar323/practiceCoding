package com.coding.practice.arrays;

public class ThreeNumberSumInRange {

	// Assumption - sorted array
	public void process(int arr[], int startRange, int endRange) {
		int len = arr.length;
		for (int i = 0; i < len - 2; i++) {
			int start = i + 1;
			int end = len - 1;

			while (start < end) {
				int temp = arr[i] + arr[start] + arr[end];
				if (temp > startRange && temp < endRange) {
					System.out.println(arr[i]);
					System.out.println(arr[start]);
					System.out.println(arr[end]);
					return;
				} else if (temp >= endRange)
					end--;
				else
					start++;
			}
		}
		System.out.println("No such numbers are found with startRange = " + startRange + " and endRange= " + endRange);

	}

	public static void main(String args[]) {
		int arr[] = { 1, 3, 4, 5, 7, 9 };
		ThreeNumberSumInRange x = new ThreeNumberSumInRange();
		x.process(arr, 10, 15);
		x.process(arr, 16, 24);
		x.process(arr, 12, 12);
		x.process(arr, 21, 26);
	}

}
