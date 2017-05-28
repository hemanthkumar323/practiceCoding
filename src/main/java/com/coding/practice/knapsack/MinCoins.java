package com.coding.practice.knapsack;

/**
 * Given a value V, if we want to make change for V cents, and we have infinite 
 * supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum 
 * number of coins to make the change?
 * @author Hemanth
 *
 */
public class MinCoins {
	
	public int minCoins(int arr[], int val) {
		int size = arr.length;
		int table[] = new int[val+1];
		
		for(int i=1; i<=size;i++) {
			for(int j=arr[i-1]; j<=val; j++) {
				table[j] = 1+table[j-arr[i-1]];
			}
		}
		return table[val];
	}

}
