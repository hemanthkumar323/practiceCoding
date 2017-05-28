package com.coding.pratice.trees;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import com.coding.practice.trees.BTree;
import com.coding.practice.trees.BTreeLevelOrderTraversal;
import com.coding.practice.trees.SampleTrees;

public class BTreeLevelOrderTraversalTest {
	
	BTreeLevelOrderTraversal sub = new BTreeLevelOrderTraversal();
	
	@Test
	public void traverse() {
		BTree tree = SampleTrees.getSampleTree();
		sub.traverse(tree);
	}
	

}
