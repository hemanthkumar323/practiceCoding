package com.coding.practice.trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/inorder-traversal/
 * 
 * @author Hemanth
 *
 */
public class InorderTraversal {
	
	public ArrayList<Integer> inorderTraversal(TreeNode a) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		if (a != null) {
			TreeNode currentNode = a;
			Stack<TreeNode> st = new Stack<TreeNode>();
			while (currentNode != null || !st.empty()) {
				while (currentNode != null) {
					st.push(currentNode);
					currentNode = currentNode.left;
				}
				if (currentNode == null) {
					currentNode = st.pop();
					output.add(currentNode.data);
					currentNode = currentNode.right;
				}
			}

		}
		return output;
	}

	public static void main(String args[]) {
		BTree node = SampleTrees.getSampleTree();
		InorderTraversal inorder = new InorderTraversal();
		System.out.println(inorder.inorderTraversal(node.rootNode));
	}

}
