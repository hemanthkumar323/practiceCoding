package com.coding.practice.graphs;

import org.junit.Test;

import com.coding.practice.graphs.BFS;
import com.coding.practice.graphs.GraphNode;
import com.coding.practice.graphs.SampleGraph;

public class BFSTest {
	
	@Test
	public void traverse() {
		GraphNode node = SampleGraph.createSampleGraph();
		BFS.traverse(node, 10);
	}
}
