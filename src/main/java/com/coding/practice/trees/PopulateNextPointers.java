package com.coding.practice.trees;

/**
 * https://www.interviewbit.com/problems/populate-next-right-pointers-tree/
 * 
 * @author challh
 *
 */
public class PopulateNextPointers {

	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	private TreeLinkNode getNextRight(TreeLinkNode node) {
		TreeLinkNode nextRight = node.next;
		while (nextRight != null) {
			if (nextRight.left != null)
				return nextRight.left;
			if (nextRight.right != null)
				return nextRight.right;
			nextRight = nextRight.next;
		}
		return nextRight;
	}

	public void connect(TreeLinkNode node) {
		if (node == null)
			return;

		TreeLinkNode currentNode = node;
		// Set null to next node of root
		currentNode.next = null;

		while (currentNode != null) {
			TreeLinkNode tempNode = currentNode;

			while (tempNode != null) {
				if (tempNode.left != null) {
					if (tempNode.right != null) {
						tempNode.left.next = tempNode.right;
					} else {
						tempNode.left.next = getNextRight(tempNode);
					}
				}

				if (tempNode.right != null) {
					tempNode.right.next = getNextRight(tempNode);
				}
				tempNode = tempNode.next;
			}

			if (currentNode.left != null)
				currentNode = currentNode.left;
			else if (currentNode.right != null)
				currentNode = currentNode.right;
			else
				currentNode = getNextRight(currentNode);

		}

	}

}
