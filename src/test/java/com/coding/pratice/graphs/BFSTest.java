package com.coding.pratice.graphs;

import org.junit.Test;

public class BFSTest {
	
	@Test
	public void traverse() {
		GraphNode node = SampleGraph.createSampleGraph();
		BFS.traverse(node, 10);
	}
}
