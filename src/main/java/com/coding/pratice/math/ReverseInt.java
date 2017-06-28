package com.coding.pratice.math;

public class ReverseInt {
	
	public int reverse(int a) {
		int x = (a > 0) ? a : a * -1;
		if( a < 0 && a+x != 0)
			return 0;
		int temp = 0, prev = 0;
		while(x > 0) {
			temp = temp * 10 + x%10;
			if(prev > temp || (prev != 0 && temp/prev < 10 ))
				return 0;
			x = x/10;
			prev = temp;
		}
		return (a > 0) ? temp : temp * -1; 
	}
	
	public static void main(String args[]) {
		ReverseInt r = new ReverseInt();
		//System.out.println(r.reverse(-1146467285));
		System.out.println(r.reverse(366245711));
		//System.out.println(r.reverse(-1234567891));
		
	}

}
