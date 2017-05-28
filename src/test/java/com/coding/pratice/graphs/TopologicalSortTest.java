package com.coding.pratice.graphs;

import org.junit.Test;

import com.coding.practice.graphs.GraphNode;
import com.coding.practice.graphs.SampleGraph;
import com.coding.practice.graphs.TopologicalSort;

public class TopologicalSortTest {
	
	TopologicalSort sub = new TopologicalSort();
	
	@Test
	public void traverse() {
		System.out.println("In ACyclic Graph");
		GraphNode node = SampleGraph.createSampleGraph();
		sub.traverse(node, 10);
	}
	
	@Test
	public void traverse_cyclicGraph() {
		System.out.println("In Cyclic Graph");
		GraphNode node = SampleGraph.selfCyclic();
		sub.traverse(node, 1);
	}
}
