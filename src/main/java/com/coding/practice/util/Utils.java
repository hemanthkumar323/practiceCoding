package com.coding.practice.util;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	
	public static List<Integer> getListFromArray(int arr[]) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++)
			list.add(arr[i]);
		return list;
	}
	
	public static List<String> getStringListFromArray(String arr[]) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++)
			list.add(arr[i]);
		return list;
	}
	
	public static void printList(List<Integer> list) {
		for(int i=0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
