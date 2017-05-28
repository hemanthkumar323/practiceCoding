package com.coding.practice.graphs;

import java.util.LinkedList;

public class BFS {
	
	public static void traverse(GraphNode rootNode, int size) {
		 LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		boolean visited[] = new boolean[size];
		visited[rootNode.data()] = true;
		queue.add(rootNode);
		while(!queue.isEmpty()) {
			GraphNode node = queue.poll();
			System.out.println(node.data());
			
			for(GraphNode childNode:node.adjLists()){
				if(visited[childNode.data()] == false) {
					queue.add(childNode);
					visited[childNode.data()] = true;
				}
			}
		}
	}

}
