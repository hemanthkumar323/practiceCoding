package com.coding.practice.arrays;

import java.util.ArrayList;

import org.junit.Test;


public class PIntegersGreaterThanPTest {
	
	PIntegersGreaterThanP sub = new PIntegersGreaterThanP();
	
	private final int[] arr1 = {  1, 2, 7, 0, 9, 3, 6, 0, 6};
	
	public void print(ArrayList<Integer> arr) {
		for(int i=0; i< arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
	
	public ArrayList<Integer> getListFromArray(int arr[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++)
			list.add(arr[i]);
		return list;
	}
	
	
	@Test
	public void process() {
		ArrayList<Integer> arrList = getListFromArray(arr1);
		sub.solve(arrList);
		print(arrList);
	}
	
}
