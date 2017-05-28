package com.coding.pratice.graphs;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class CycleDetectionTest {
	
	@Test
	public void noCycle() {
		GraphNode node = SampleGraph.createSampleGraph();
		assertThat(CycleDetection.isCyclic(node, 10)).isFalse();
	}
	
	@Test
	public void cycle() {
		GraphNode node = SampleGraph.cyclicGraph();
		assertThat(CycleDetection.isCyclic(node, 3)).isTrue();
	}
	
	@Test
	public void selfCycle() {
		GraphNode node = SampleGraph.selfCyclic();
		assertThat(CycleDetection.isCyclic(node, 1)).isTrue();
	}

}
