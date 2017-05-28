package com.coding.pratice.graphs;

public class CycleDetection {
	
	public static boolean isCyclic(GraphNode root, boolean visited[], boolean recurList[]) {
		if(visited[root.data()] == false) {
			visited[root.data()] = true;
			recurList[root.data()] = true;
			for(GraphNode node:root.adjLists()) {
				if(visited[node.data()] == false && isCyclic(node, visited, recurList)) 
					return true;
				else if(recurList[node.data()] == true)
					return true;
			}
		}
		recurList[root.data()] = false;
		return false;
	}
	
	public static boolean isCyclic(GraphNode node, int size) {
		boolean visited[] = new boolean[size];
		boolean recurList[] = new boolean[size];
		return isCyclic(node, visited, recurList);
	}

}
