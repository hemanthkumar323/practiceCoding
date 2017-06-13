package com.coding.practice.trees;

public class IdenticalTrees {
	
	public int isSameTree(TreeNode a, TreeNode b) {
		if(a == null && b == null)
			return 1;
		if(a == null || b == null)
			return 0;
		if(a.data != b.data)
			return 0;
		int isLeft = isSameTree(a.left, b.left);
		int isRight = isSameTree(a.right, b.right);
		if(isLeft == 0 || isRight == 0)
			return 0;
		return 1;
	}
	
	public static void main(String args[]) {
		IdenticalTrees trees = new IdenticalTrees();
	}

}
