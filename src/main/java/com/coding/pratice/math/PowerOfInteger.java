package com.coding.pratice.math;

import java.util.HashMap;

public class PowerOfInteger {
	
	public boolean isPower1(int a) {
		if(a<2)
			return true;
		HashMap<Integer, Integer> divisorMap = computeDivisors(a);
		int size = divisorMap.size();
		System.out.println(divisorMap);
		
		int count = 0, prevCount = 0;
		for(int x: divisorMap.keySet()) {
			int current_count = divisorMap.get(x);
			if(count == 0) {
				count = current_count;
			} else if(count != current_count && count % current_count != 0 && current_count % count != 0) {
				return false;
			}
			
		}
		
		if(count == 1)
			return false;
		return true;
    }
	
	private HashMap<Integer, Integer> computeDivisors(int x) {
		HashMap<Integer, Integer> output = new HashMap<Integer, Integer>();
		int count = 0;
		while(x%2 == 0) {
			x = x/2;
			count++;
		}
		if(count != 0)
			output.put(2, count);
		int sqrt =(int)Math.sqrt(x);
		
		int i=3;
		while( i <=sqrt+1 && x>1) {
			count = 0;
			while(x%i == 0) {
				x = x/i;
				count++;
			}
			output.put(i, count);
		}
		return output;
	}
	
	public boolean isPower(int a) {
		if(a < 2)
			return true;
		
		int sqrt = (int)Math.sqrt(a);
		for(int i=2; i<= sqrt+1; i++) {
			int p = 2;
			int pow = (int)Math.pow(i, p);
			
			while(pow > 0 && pow <= a) {
				if(pow == a) 
					return true;
				p++;
				pow = (int)Math.pow(i, p);
			}
		}
		
		return false;
		
	}

}
