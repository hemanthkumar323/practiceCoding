package com.coding.pratice.graphs;

public class DFS {

	public static void traverse(GraphNode root, boolean visited[]) {
		if (visited[root.data()] == false) {
			visited[root.data()] = true;
			System.out.println(root.data());
			for (GraphNode childNode : root.adjLists()) {
				traverse(childNode, visited);
			}
		}
	}
	
	public static void traverse(GraphNode node, int size) {
		boolean visited[] = new boolean[size];
		traverse(node, visited);
	}
}
