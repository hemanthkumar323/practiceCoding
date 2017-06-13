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
		TreeNode jnode = new TreeNode(9);
		TreeNode inode = new TreeNode(8);
		TreeNode hnode = new TreeNode(7);
		TreeNode gnode = new TreeNode(6);
		TreeNode fnode = new TreeNode(5);
		
		TreeNode enode = new TreeNode(4, null, jnode);
		TreeNode dnode = new TreeNode(3, hnode, inode);
		
		TreeNode bnode = new TreeNode(1, dnode, enode);
		TreeNode cnode = new TreeNode(2, fnode, gnode);
		
		TreeNode anode = new TreeNode(0, bnode, cnode);
		
		return new BTree(anode);
		
		
	}
}
