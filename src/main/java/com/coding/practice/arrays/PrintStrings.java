package com.coding.practice.arrays;

import java.util.ArrayList;

public class PrintStrings {
	public ArrayList<String> fizzBuzz(int A) {
		ArrayList<String> output = new ArrayList<String>();
		for(int i=1;i<=A;i++) {
			if(i%15==0) {
				output.add("FizzBuzz");
			} else if(i%3==0) {
				output.add("Fizz");
			} else if(i%5==0) {
				output.add("Buzz");
			} else {
				output.add(""+i);
			}	
		}
		return output;
	}
	
	public int titleToNumber(String a) {
		int size = a.length();
		int val = 0;
		for(int i=size-1;i>0;i++) {
			int temp = a.charAt(i) - 64;
			val = val + (temp * (int)Math.pow(26, size-i-1));
		}
		return val;
	}
	
	public static int uniquePaths(int a, int b) {
		return countPaths(0,0,a-1,b-1);
	}
	
	public static int countPaths(int startX, int endX, int startY, int endY) {
		if(startX == startY && endX == endY) {
			return 1;
		} else if(startX>startY || endX>endY) {
			return 0;
		} else {
			return countPaths(startX+1, endX, startY, endY) +
					countPaths(startX, endX+1, startY, endY);
		}
	}
	
	public static void main(String args[]) {
		System.out.println(uniquePaths(2,2));
	}

}
