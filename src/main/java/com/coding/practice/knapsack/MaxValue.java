package com.coding.practice.knapsack;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items 
 * respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that 
 * sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or 
 * don’t pick it (0-1 property)
 * @author Hemanth
 *
 */
public class MaxValue {
	
	public int maxValue(int wts[], int val[], int capacity) {
		int size = wts.length;
		int arr[][] = new int[size+1][capacity+1];
		
		
		for(int i=0; i<=size; i++) {
			for(int j=0; j<=capacity; j++) {
				if(i==0 || j==0)
					arr[i][j] = 0;
				else if(wts[i-1] <= j) {
					arr[i][j] = max(val[i-1]+arr[i-1][j-wts[i-1]], arr[i-1][j]);
				} else {
					arr[i][j] = arr[i-1][j];
				}
			}
		}
		//print(arr, size+1, capacity+1);
		return arr[size][capacity];
	}
	
	private static int max(int a, int b) {
		return (a>b) ? a : b;
	}
	
	private void print(int arr[][], int m, int n) {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("\n");
		}
		
	}

}
