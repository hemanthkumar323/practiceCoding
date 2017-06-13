package com.coding.practice.trees;

public class MaxDepth {
	
	public int maxDepth(TreeNode node) {
		if(node == null)
			return 0;
		int left = maxDepth(node.left);
		int right = maxDepth(node.right);
		return (left > right) ? left+1 : right+1;
		
	}
}
