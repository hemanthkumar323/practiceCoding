package com.coding.practice.trees;

import java.util.ArrayList;

public class BTreeFromPreAndInOrderTraversal {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Index {
		int ind;
	}

	public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
		Index preOrderIndex = new Index();
		preOrderIndex.ind = 0;
		int size = inorder.size();
		return buildTreeUtil(preorder, inorder, 0, size - 1, preOrderIndex);
	}

	private TreeNode buildTreeUtil(ArrayList<Integer> preorder, ArrayList<Integer> inorder, int inOrderStart,
			int inOrderEnd, Index preOrderIndex) {
		
		if(inOrderStart > inOrderEnd) 
			return null;
		int ele = preorder.get(preOrderIndex.ind);
		TreeNode node = new TreeNode(ele);
		preOrderIndex.ind = preOrderIndex.ind + 1;
		
		if(inOrderStart == inOrderEnd) {
			return node;
		}
		int ind = searchIndex(inorder, inOrderStart, inOrderEnd, ele);
		node.left = buildTreeUtil(preorder, inorder, inOrderStart, ind-1, preOrderIndex);
		node.right = buildTreeUtil(preorder, inorder, ind+1, inOrderEnd, preOrderIndex);
		return node;
		
		
	}
	
	private int searchIndex(ArrayList<Integer> inorder, int start, int end, int data) {
		for(int i=start; i<=end; i++) {
			if(inorder.get(i) == data) {
				return i;
			}
		}
		return -1;
	}

}
