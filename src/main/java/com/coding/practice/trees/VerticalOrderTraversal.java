package com.coding.practice.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * https://www.interviewbit.com/problems/vertical-order-traversal-of-binary-tree/
 * @author Hemanth
 *
 */
public class VerticalOrderTraversal {
	
	class TreeNodeWithLevel {
		TreeNode node;
		int level;
		
		TreeNodeWithLevel(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}
	
	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		 ArrayList<ArrayList<Integer>> output = new  ArrayList<ArrayList<Integer>>();
		 HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		 verticalOrderTraversal(A, map);
		 int minLevel = Integer.MAX_VALUE;
		 int maxLevel = Integer.MIN_VALUE;
		 for(int x: map.keySet()) {
			 if(x < minLevel)
				 minLevel = x;
			 if(x > maxLevel)
				 maxLevel = x;
		 }
		 for(int i= minLevel; i<= maxLevel; i++) {
			 output.add(map.get(i));
		 }
		 return output;
    }
	
	
	// Do a level order traversal
	private void verticalOrderTraversal(TreeNode node, HashMap<Integer, ArrayList<Integer>> map) {
		if(node == null)
			return;
		LinkedList<TreeNodeWithLevel> list = new LinkedList<TreeNodeWithLevel>();
		list.add(new TreeNodeWithLevel(node, 0));
		
		while(!list.isEmpty()) {
			TreeNodeWithLevel nodeWithLevel = list.removeFirst();
			TreeNode temp = nodeWithLevel.node;
			int level = nodeWithLevel.level;
			if(map.containsKey(level)) {
				ArrayList<Integer> mapList = map.get(level);
				mapList.add(temp.data);
				map.put(level, mapList);
			} else {
				ArrayList<Integer> mapList = new ArrayList<Integer>();
				mapList.add(temp.data);
				map.put(level, mapList);
			}
			//System.out.println(temp.getData());
			if(temp.left != null)
				list.add(new TreeNodeWithLevel(temp.left, level-1));
			if(temp.right != null)
				list.add(new TreeNodeWithLevel(temp.right, level+1));
		}
	}
	
	
	public static void main(String args[]) {
		BTree tree = SampleTrees.getSampleTree();
		VerticalOrderTraversal v = new VerticalOrderTraversal();
		System.out.println(v.verticalOrderTraversal(tree.getRootNode()));
	}

}
