package com.coding.practice.trees;

public class InvertBinaryTree {
	
	public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return root;
		if(root.left == null && root.right == null)
			return root;
		TreeNode temp = root.right;
		root.right = invertTree(root.left);
		root.left = invertTree(temp);
		return root;
    }

}
