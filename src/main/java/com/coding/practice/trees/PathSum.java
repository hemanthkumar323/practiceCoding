package com.coding.practice.trees;

public class PathSum {
	
	public int hasPathSum(TreeNode a, int b) {
		if(a == null)
			return 0;
		return hasPathSumUtil(a, b, 0);
		
	}
	
	private int hasPathSumUtil(TreeNode a, int b, int currentSum) {
		if(a == null)
			return 0;
		int data = a.data;
		if(a.left == null && a.right == null) {
			if(currentSum + data == b)
				return 1;
			return 0;
		}
		int leftVal =  hasPathSumUtil(a.left, b, data+currentSum);
		int rightVal =  hasPathSumUtil(a.right, b, data+currentSum);
		if(leftVal==1 || rightVal==1)
			return 1;
		return 0;
	}

}
