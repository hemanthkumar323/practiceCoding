package com.coding.practice.trees;

// Range minimum Query.
// Construct a segment tree and try to query the segment tree for min
public class RMQ {
	
	int segmentTree[];
	
	public void constructTree(int arr[]) {
		int size = arr.length;
		segmentTree = new int[2*size+1];
		constructTreeUtil(arr, 0, size-1, segmentTree, 0);
	}
	
	public int constructTreeUtil(int arr[], int start, int end, int tree[], int currentIndex) {
		if(start == end) {
			tree[currentIndex] = arr[start];
			return arr[start];
		}
		int mid = start + (end-start)/2;
		int left = constructTreeUtil(arr, start, mid, tree, 2*currentIndex+1);
		int right = constructTreeUtil(arr, mid+1, end, tree, 2*currentIndex+2);
		tree[currentIndex] = min(left, right);
		return tree[currentIndex];
	}
	
	public int query(int size, int queryStart, int queryEnd) {
		return queryUtil(0, size-1, queryStart, queryEnd, 0);
	}
	
	public int queryUtil(int start, int end, int queryStart, int queryEnd, int currentIndex) {
		if(queryStart <= start && queryEnd >= end) {
			return segmentTree[currentIndex];
		}
		
		// If the segment is out of range of this query
		if(queryStart > end || queryEnd < start)
			return Integer.MAX_VALUE;
		
		int mid = start + (end-start)/2;
		return min(queryUtil(start, mid, queryStart, queryEnd, 2*currentIndex+1),
				queryUtil(mid+1, end, queryStart, queryEnd, 2*currentIndex+2));
	}
	
	public void printSegmentTree() {
		for (int i=0;i<segmentTree.length; i++) 
			System.out.println(i+ "th element - " + segmentTree[i]);
	}
	
	private int min(int x, int y) {
		return (x < y) ? x : y;
	}

}
