package com.coding.practice.trees;

public class BTreeFromPostAndInOrderTraversal {
	
	// Need to pass by reference
	class Index {
		int index;
		
		Index(int index) {
			this.index = index;
		}
	}
	
	public BTree buildBTree(int inorder[], int postorder[], int size) {
		Index postOrderIndex = new Index(size-1);
		BTreeNode rootNode = buildBTreeUtil(inorder, postorder, 0, size-1, postOrderIndex);
		return new BTree(rootNode);
	}
	
	public BTreeNode buildBTreeUtil(int inorder[], int postorder[], 
			int inStart, int inEnd, Index postOrderIndex) {
		
		if(inStart > inEnd) {
			return null;
		}
		int currentNodeData = postorder[postOrderIndex.index];
		BTreeNode newNode = new BTreeNode(currentNodeData);
		postOrderIndex.index = postOrderIndex.index-1;
		
		if(inStart == inEnd)
			return newNode;
		int inorderIndex = searchIndex(inorder, inStart, inEnd, currentNodeData);
		
		newNode.setRight(buildBTreeUtil(inorder, postorder, inorderIndex+1, inEnd, postOrderIndex));
		newNode.setLeft(buildBTreeUtil(inorder, postorder, inStart, inorderIndex-1, postOrderIndex));
		return newNode;
	}
	
	private int searchIndex(int inorder[], int start, int end, int data) {
		for(int i=start; i<=end; i++) {
			if(inorder[i] == data) {
				return i;
			}
		}
		return -1;
	}

}
