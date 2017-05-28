package com.coding.practice.trees;

import java.util.LinkedList;

public class BTreeLevelOrderTraversal {
	
	public void traverse(BTree tree) {
		BTreeNode rootNode = tree.getRootNode();
		LinkedList<BTreeNode> list = new LinkedList<BTreeNode>();
		list.add(rootNode);
		
		while(!list.isEmpty()) {
			BTreeNode temp = list.removeFirst();
			System.out.println(temp.getData());
			if(temp.getLeft() != null)
				list.add(temp.getLeft());
			if(temp.getRight() != null)
				list.add(temp.getRight());
		}
	}

}
