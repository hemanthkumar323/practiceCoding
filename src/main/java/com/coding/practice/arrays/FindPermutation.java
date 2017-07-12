package com.coding.practice.arrays;

import java.util.ArrayList;

public class FindPermutation {
	
	public ArrayList<Integer> findPerm(final String A, int B) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(int i=0; i<B; i++) 
			output.add(i+1);
		
		for(int i=0; i<B-1; i++) {
			if(A.charAt(i) == 'D') {
				int start = i;
                while (i < B-1 && A.charAt(i) == 'D') 
                	i++;
                int end = i;
                // reverse from start to i
                while(start < end) {
                	int temp = output.get(end);
                	output.set(end, output.get(start));
                	output.set(start, temp);
                	start++;
                	end--;
                }
			}
		}
		
		return output;
    }

	public static void main(String args[]) {
		FindPermutation m = new FindPermutation();
		System.out.println(m.findPerm("DDD", 4));
	}
}
