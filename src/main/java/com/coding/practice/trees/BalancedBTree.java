package com.coding.practice.trees;

public class BalancedBTree {
	public int isBalancedUtil(TreeNode a) {
		if(a == null)
			return 0;
		int leftHeight = isBalancedUtil(a.left);
		int rightHeight = isBalancedUtil(a.right);
		if(leftHeight == -1 || rightHeight==-1 || Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;	
	}
	
	public int isBalanced(TreeNode a) {
		if(a == null)
			return 1;
		if(isBalancedUtil(a) == -1)
			return 0;
		return 1;
		
	}

}
