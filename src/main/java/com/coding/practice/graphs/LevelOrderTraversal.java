package com.coding.practice.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class LevelOrderTraversal {
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		if(root==null)
			return output; 
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<TreeNode> nextLevelQueue = new LinkedList<TreeNode>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode temp = q.remove();
			list.add(temp.val);
			if(temp.left != null)
				nextLevelQueue.add(temp.left);
			if(temp.right != null)
				nextLevelQueue.add(temp.right);
			if(q.isEmpty()) {
				output.add(list);
				list= new ArrayList<Integer>();
				q = nextLevelQueue;
				nextLevelQueue = new LinkedList<TreeNode>();
			}
		}
		return output;
	}

}
