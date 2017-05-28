package com.coding.pratice.trees;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import com.coding.practice.trees.BTree;
import com.coding.practice.trees.BTreeFromPostAndInOrderTraversal;
import com.coding.practice.trees.BTreeLevelOrderTraversal;

public class BTreeFromPostAndInOrderTraversalTest {
	BTreeFromPostAndInOrderTraversal sub = new BTreeFromPostAndInOrderTraversal();
	
	@Test
	public void buildTree() {
		int inorder[] = {2,1,3};
		int postorder[] = {2,3,1};
		int size = 3;
		BTree tree = sub.buildBTree(inorder, postorder, size);
		
		BTreeLevelOrderTraversal traversal = new BTreeLevelOrderTraversal();
		traversal.traverse(tree);
	}
	
	@Test
	public void buildTree2() {
		int inorder[] = {4, 8, 2, 5, 1, 6, 3, 7};
		int postorder[] = {8, 4, 5, 2, 6, 7, 3, 1};
		int size = 8;
		BTree tree = sub.buildBTree(inorder, postorder, size);
		
		BTreeLevelOrderTraversal traversal = new BTreeLevelOrderTraversal();
		traversal.traverse(tree);
	}

}
