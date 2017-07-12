package com.coding.pratice.math;

/**
 * https://www.interviewbit.com/problems/excel-column-title/
 * 
 * @author Hemanth
 *
 */
public class ExcelColumnTitle {

	public String convertToTitle(int a) {
		String output = "";
		int temp = a;
		while (temp != 0) {
			int mod = temp % 26;
			mod = (mod == 0) ? 26 : mod;
			temp = (temp-mod) / 26;
			char ch = (char) ('A' - 1 + mod);
			output = ch + output;
		}

		return output;
	}

	public static void main(String args[]) {
		ExcelColumnTitle e = new ExcelColumnTitle();
		System.out.println(e.convertToTitle(1000));
		System.out.println(e.convertToTitle(152));
		System.out.println(e.convertToTitle(1));
		System.out.println(e.convertToTitle(26));
	}

}
