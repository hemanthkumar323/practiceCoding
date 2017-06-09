package com.coding.practice.stack;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> mainStack, minStack;

	public MinStack() {
		this.mainStack = new Stack<Integer>();
		this.minStack = new Stack<Integer>();
	}

	public void push(int x) {
		mainStack.push(x);
		if (minStack.size() == 0 || minStack.peek() >= x)
			minStack.push(x);
	}

	public void pop() {
		int size = mainStack.size();
		if (size == 0)
			return;
		int topOfMainStack = mainStack.pop();
		int topOfMinStack = minStack.peek();
		if (topOfMinStack == topOfMainStack)
			minStack.pop();
	}

	public int top() {
		int size = mainStack.size();
		if (size == 0)
			return -1;
		return mainStack.peek();
	}

	public int getMin() {
		int size = mainStack.size();
		if (size == 0)
			return -1;
		return minStack.peek();
	}

	public static void main(String args[]) {
		MinStack ex = new MinStack();
		ex.push(10);
		System.out.println(ex.getMin());
		ex.push(20);
		ex.push(5);
		System.out.println(ex.getMin());
		ex.pop();
		System.out.println(ex.getMin());
		
		System.out.println(ex.top());
	}

}
