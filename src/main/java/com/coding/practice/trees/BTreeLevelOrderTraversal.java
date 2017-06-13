package com.coding.practice.trees;

import java.util.LinkedList;

public class BTreeLevelOrderTraversal {
	
	public void traverse(BTree tree) {
		TreeNode rootNode = tree.getRootNode();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(rootNode);
		
		while(!list.isEmpty()) {
			TreeNode temp = list.removeFirst();
			System.out.println(temp.getData());
			if(temp.getLeft() != null)
				list.add(temp.getLeft());
			if(temp.getRight() != null)
				list.add(temp.getRight());
		}
	}

}
