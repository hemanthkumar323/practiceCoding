package com.coding.practice.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class ZigZagTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		if (a != null) {
			boolean leftToRight = false;
			Stack<TreeNode> currentLevel = new Stack<TreeNode>();
			Stack<TreeNode> nextLevel = new Stack<TreeNode>();
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			currentLevel.push(a);
			while (!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
				TreeNode temp = currentLevel.pop();
				if (temp != null) {
					list.add(temp.data);
					if (!leftToRight) {
						if (temp.left != null)
							nextLevel.push(temp.left);
						if (temp.right != null)
							nextLevel.push(temp.right);

					} else {
						if (temp.right != null)
							nextLevel.push(temp.right);
						if (temp.left != null)
							nextLevel.push(temp.left);
					}
				}
				if(currentLevel.isEmpty()) {
					output.add(list);
					list = new ArrayList<Integer>();
					leftToRight = !leftToRight;
					currentLevel = nextLevel;
					nextLevel = new Stack<TreeNode>();
					
				}
			}

		}
		return output;
	}
	
	public static void main(String args[]) {
		BTree tree = SampleTrees.getSampleTree();
		ZigZagTraversal v = new ZigZagTraversal();
		System.out.println(v.zigzagLevelOrder(tree.getRootNode()));
	}

}
