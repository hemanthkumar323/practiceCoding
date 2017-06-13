package com.coding.practice.trees;

import java.util.ArrayList;

public class RootToLeafPathSum {

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		if (root != null)
			pathSumUtil(root, sum, 0, new ArrayList<Integer>(), output);
		return output;
	}

	private void pathSumUtil(TreeNode a, int b, int currentSum, ArrayList<Integer> currentList,
			ArrayList<ArrayList<Integer>> output) {
		if (a == null)
			return;
		int data = a.data;
		ArrayList<Integer> temp = new ArrayList<Integer>(currentList);
		temp.add(data);
		if (a.left == null && a.right == null) {
			if (currentSum + data == b) {
				output.add(temp);
			}
			return;
		}
		pathSumUtil(a.left, b, data + currentSum, temp, output);
		pathSumUtil(a.right, b, data + currentSum, temp, output);
	}

	public static void main(String args[]) {
		RootToLeafPathSum sum = new RootToLeafPathSum();
		System.out.println(sum);
	}

}
