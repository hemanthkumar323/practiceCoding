package com.coding.practice.arrays;

import java.util.ArrayList;

public class RotateArray {
	
	// rotates by 90 degrees clockwise
	public void rotate(ArrayList<ArrayList<Integer>> a) {
		int size = a.size();
		
		for(int i=0; i<size/2; i++) {
			for(int j=i; j<size-i-1; j++) {
				ArrayList<Integer> iList = a.get(i);
				ArrayList<Integer> jList = a.get(j);
				ArrayList<Integer> sizeMinusIList = a.get(size-1-i);
				ArrayList<Integer> sizeMinusJList = a.get(size-1-j);
				
				// store current cell in temp variable
				int temp = iList.get(j);
	            // move values from right to top
	            iList.set(j, sizeMinusJList.get(i));
	            // move values from bottom to right
	            sizeMinusJList.set(i, sizeMinusIList.get(size-1-j));
	            // move values from left to bottom
	            sizeMinusIList.set(size-1-j, jList.get(size-1-i));
	            // assign temp to left
	            jList.set(size-1-i, temp);
	            
			}
			
			
			
		}
	}
	
	// rotates by 90 degrees anti-clockwise
	public void rotateAntiClockWise(ArrayList<ArrayList<Integer>> a) {
		int size = a.size();
		
		for(int i=0; i<size/2; i++) {
			
			for(int j=i; j<size-i-1; j++) {
				ArrayList<Integer> iList = a.get(i);
				ArrayList<Integer> jList = a.get(j);
				ArrayList<Integer> sizeMinusIList = a.get(size-1-i);
				ArrayList<Integer> sizeMinusJList = a.get(size-1-j);
				
				
				// store current cell in temp variable
				int temp = iList.get(j);
	 
	            // move values from right to top
	            iList.set(j, jList.get(size-1-i));
	 
	            // move values from bottom to right
	            jList.set(size-1-i, sizeMinusIList.get(size-1-j));
	 
	            // move values from left to bottom
	            sizeMinusIList.set(size-1-j, sizeMinusJList.get(i));
	 
	            // assign temp to left
	            sizeMinusJList.set(i, temp);
	            
	            print(a);
				System.out.println("---------------------------------");
			}
			
		}
	}
	
	public static void main(String args[]) {
		int line1[] = {1,2,3};
		int line2[] = {4,5,6};
		int line3[] = {7,8,9};
		RotateArray rotateArray = new RotateArray();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		list.add(rotateArray.getListFromArray(line1));
		list.add(rotateArray.getListFromArray(line2));
		list.add(rotateArray.getListFromArray(line3));
		
		rotateArray.rotate(list);
		rotateArray.print(list);
	}
	
	public ArrayList<Integer> getListFromArray(int arr[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++)
			list.add(arr[i]);
		return list;
	}
	
	public void print(ArrayList<ArrayList<Integer>> list) {
		int size = list.size();
		for(int i = 0;i < size;i++) {
			ArrayList<Integer> subList = list.get(i);
			for(int j=0; j<size;j++) {
				System.out.print(" "+ subList.get(j));
			}
			System.out.println("");
		}
	}
}
