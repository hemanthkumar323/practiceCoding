package com.coding.practice.stack;

import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/simplify-directory-path/
 * 
 * @author Hemanth
 *
 */
public class SimplifyDirectoryPath {

	public String simplifyPath(String a) {
		if (a == null || a.length() <= 1)
			return a;
		int size = a.length();
		int i = 0;
		Stack<Character> st = new Stack<Character>();
		while (i < size) {
			char ch = a.charAt(i);
			int count_of_dots = 0;
			while (a.charAt(i) == '.') {
				i++;
				count_of_dots++;
			}
			if (count_of_dots == 1)
				st.pop();
			else if (count_of_dots == 2) {
				st.pop();
				while(st.peek() != '/')
					st.pop();
				i++;
			} else if (count_of_dots > 2) {
				for (int j = 0; j < count_of_dots; j++)
					st.push('.');
			} else {
				if (!(i == size - 1 && ch == '/')) {
					st.push(ch);
				}
				i++;
			}
		}

		int newSize = st.size();
		char chars[] = new char[newSize];
		for (i = newSize - 1; i >= 0; i--) {
			chars[i] = st.pop();
		}

		String output = String.copyValueOf(chars);
		if(output.endsWith("/"))
			return output.substring(0, newSize-1);
		return output;
	}
	
	public static void main(String args[]) {
		SimplifyDirectoryPath m = new SimplifyDirectoryPath();
		System.out.println(m.simplifyPath("/a/./b/../../c/"));
	}

}
