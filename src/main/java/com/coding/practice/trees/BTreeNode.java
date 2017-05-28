package com.coding.practice.trees;

public class BTreeNode {
	int data;
	BTreeNode left, right;
	
	public BTreeNode() {
	}
	
	public BTreeNode(int data) {
		this.data = data;
	}
	
	public BTreeNode(int data, BTreeNode left, BTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BTreeNode getLeft() {
		return left;
	}
	public void setLeft(BTreeNode left) {
		this.left = left;
	}
	public BTreeNode getRight() {
		return right;
	}
	public void setRight(BTreeNode right) {
		this.right = right;
	}
}
