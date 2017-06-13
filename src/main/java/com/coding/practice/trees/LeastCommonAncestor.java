package com.coding.practice.trees;

/**
 * https://www.interviewbit.com/problems/least-common-ancestor/
 * @author Hemanth
 *
 */
public class LeastCommonAncestor {
	
	public int lca(TreeNode a, int val1, int val2) {
		boolean v1 = isNodePresent(a, val1);
		boolean v2 = isNodePresent(a, val2);
		if(v1 && v2) {
			TreeNode node = lcaUtil(a, val1, val2);
			if(node == null)
				return -1;
			return node.data;
		}
		return -1;
	}
	
	private boolean isNodePresent(TreeNode a, int val) {
		if(a == null)
			return false;
		if(a.data == val)
			return true;
		boolean left = isNodePresent(a.left, val);
		boolean right = isNodePresent(a.right, val);
		return left | right;
	}
	
	private TreeNode lcaUtil(TreeNode a, int val1, int val2) {
		if(a == null)
			return null;
		if(a.data == val1 || a.data == val2)
			return a;
		
		TreeNode leftIndex = lcaUtil(a.left, val1, val2);
		TreeNode rightIndex = lcaUtil(a.right, val1, val2);
		if(leftIndex != null && rightIndex != null)
			return a;
		return (leftIndex == null) ? rightIndex : leftIndex;
	}

}
