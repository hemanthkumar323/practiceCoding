package com.coding.practice.trees;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {
	
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		if (a != null) {
			Stack<TreeNode> st = new Stack<TreeNode>();
			st.push(a);
			while (!st.empty()) {
				TreeNode temp = st.pop();
				output.add(temp.data);

				if (temp.right != null)
					st.push(temp.right);
				if (temp.left != null)
					st.push(temp.left);

			}

		}
		return output;
	}


}
