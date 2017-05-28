package com.coding.pratice.graphs;

import org.junit.Test;

public class DFSTest {
	
	@Test
	public void traverse() {
		System.out.println("In ACyclic Graph");
		GraphNode node = SampleGraph.createSampleGraph();
		DFS.traverse(node, 10);
	}
	
	@Test
	public void traverse_cyclicGraph() {
		System.out.println("In Cyclic Graph");
		GraphNode node = SampleGraph.selfCyclic();
		DFS.traverse(node, 1);
	}
}
