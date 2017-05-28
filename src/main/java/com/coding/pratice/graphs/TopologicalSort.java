package com.coding.pratice.graphs;

public class TopologicalSort {
	
	public void traverse(GraphNode node, boolean visited[]) {
		if(visited[node.data()] == false) {
			visited[node.data()] = true;
			for(GraphNode childNode:node.adjLists()) {
				traverse(childNode, visited);
			}
			System.out.println(node.data());
		}
	}
	
	public void traverse(GraphNode node, int size) {
		boolean visited[] = new boolean[size];
		traverse(node, visited);
	}

}
