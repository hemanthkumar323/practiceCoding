package com.coding.practice.stack;

import java.util.ArrayList;
import java.util.Stack;

import com.coding.practice.util.Utils;

public class EvaluateExpression {
	
	private static final String PLUS = "+";
	private static final String MINUS = "-";
	private static final String MUL = "*";
	private static final String DIV = "/";
	
	public int evalRPN(ArrayList<String> a) {
		int size = a.size();
		Stack<String> st = new Stack<String>();
		for(int i=0; i<size; i++) {
			String temp = a.get(i);
			if(!isOperator(temp)) {
				st.push(temp);
			} else {
				int top1 = Integer.parseInt(st.pop());
				int top2 = Integer.parseInt(st.pop());
				int result = performOp(top2, top1, temp);
				st.push(String.valueOf(result));
			}
		}
		return Integer.parseInt(st.pop());
	}
	
	private int performOp(int x, int y, String operation) {
		if(operation.equals(PLUS)) {
			return x+y;
		} else if(operation.equals(MINUS)) {
			return x - y;
		} else if(operation.equals(MUL)) {
			return x * y;
		} else 
			return x/y;
		
	}
	
	private boolean isOperator(String str) {
		String validOps[] = {PLUS, MINUS, MUL, DIV};
		for(int i = 0; i< validOps.length; i++) {
			if(str.equals(validOps[i]))
				return true;
		}
		return false;
	}
	
	public static void main(String args[]) {
		String arr[] = {"2", "1", "+", "3", "*"};
		EvaluateExpression eval = new EvaluateExpression();
		System.out.println(eval.evalRPN((ArrayList<String>)Utils.getStringListFromArray(arr)));
	}

}
