package com.coding.practice.stack;

import java.util.Stack;

public class RedundantBraces {
	public int braces(String a) {
		Stack<Integer> st = new Stack<Integer>();
		int len = a.length();
		int prevIndex = -1;
		for(int i=0; i<len; i++) {
			char ch = a.charAt(i);
			if(ch == ')') {
				if( prevIndex!=-1 && st.peek() - prevIndex == -1 || i-st.peek() == 2)
					return 1;
				else
					prevIndex = st.pop();
			} else {
				if(ch == '(') {
					st.push(i);
				}
				prevIndex = -1;
			}
		} 
		return 0;
	}
	
	public static void main(String args[]) {
		RedundantBraces braces = new RedundantBraces();
		System.out.println(braces.braces("(a+(b+c))"));
	}
}
