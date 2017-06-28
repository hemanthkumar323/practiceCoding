package com.coding.practice.dp;

import java.util.List;

import com.coding.practice.util.Utils;

/**
 * https://www.interviewbit.com/problems/tushars-birthday-party/
 * @author Hemanth
 *
 */
public class TusharsBirthDayParty {
	public int solve(final List<Integer> eatingCapacity, final List<Integer> capacityOfDish, final List<Integer> cost) {
		int size = eatingCapacity.size();
		int capacityOfDishSize = capacityOfDish.size();
		int maxEatingCapacity = Integer.MIN_VALUE; 
		for(int i=1; i< size; i++)
			if(eatingCapacity.get(i) > maxEatingCapacity)
				maxEatingCapacity = eatingCapacity.get(i);
		
		int dp [] = new int[maxEatingCapacity+1];
		
		for(int i=0; i<=maxEatingCapacity; i++) {
			for(int j=0; j< capacityOfDishSize; j++) {
				int ele = capacityOfDish.get(j);
				if(ele <= i) {
					dp[i] = (dp[i] == 0)  ? cost.get(j) + dp[i-ele] : Math.min(cost.get(j) + dp[i-ele], dp[i]);
				}
			}
		}
		
		int totalCost = 0;
		for(int i=0; i< size; i++) {
			totalCost += dp[eatingCapacity.get(i)];
		}
		return totalCost;
    }
	
	public static void main(String args[]) {
		int arr1[] = {2,4,6};
		int arr2[] = {2,1,3};
		int arr3[] = {2,5,3};
		TusharsBirthDayParty p = new TusharsBirthDayParty();
		System.out.println(p.solve(Utils.getListFromArray(arr1), Utils.getListFromArray(arr2), Utils.getListFromArray(arr3)));
		
	}
}
