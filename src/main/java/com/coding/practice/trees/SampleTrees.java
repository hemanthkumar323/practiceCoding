package com.coding.practice.trees;

public class SampleTrees {

	/**
	 *                   a-0
	 *            b-1               c-2
	 *       d-3        e-4     f-5          g-6
	 *  h-7       i-8       j-9
	 * 
	 */
	public static BTree getSampleTree() {
		BTreeNode jnode = new BTreeNode(9);
		BTreeNode inode = new BTreeNode(8);
		BTreeNode hnode = new BTreeNode(7);
		BTreeNode gnode = new BTreeNode(6);
		BTreeNode fnode = new BTreeNode(5);
		
		BTreeNode enode = new BTreeNode(4, null, jnode);
		BTreeNode dnode = new BTreeNode(3, hnode, inode);
		
		BTreeNode bnode = new BTreeNode(1, dnode, enode);
		BTreeNode cnode = new BTreeNode(2, fnode, gnode);
		
		BTreeNode anode = new BTreeNode(0, bnode, cnode);
		
		return new BTree(anode);
		
		
	}
}
