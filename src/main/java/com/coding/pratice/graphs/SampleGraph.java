package com.coding.pratice.graphs;

import com.google.common.collect.ImmutableList;

public class SampleGraph {
	
	/**
	 *                   a-0
	 *            b-1               c-2
	 *       d-3        e-4     f-5          g-6
	 *           h-7       i-8       j-9
	 * 
	 */
	public static GraphNode createSampleGraph() {
		// Leaf Nodes
		GraphNode hNode = new GraphNode.GraphNodeBuilder().data(7).build();
		GraphNode iNode = new GraphNode.GraphNodeBuilder().data(8).build();
		GraphNode jNode = new GraphNode.GraphNodeBuilder().data(9).build();
		
		// Internal Nodes
		GraphNode dNode = new GraphNode.GraphNodeBuilder()
				.data(3)
				.adjLists(ImmutableList.of(hNode))
				.build();
		GraphNode eNode = new GraphNode.GraphNodeBuilder()
				.data(4)
				.adjLists(ImmutableList.of(hNode, iNode))
				.build();
		GraphNode fNode = new GraphNode.GraphNodeBuilder()
				.data(5)
				.adjLists(ImmutableList.of(iNode, jNode))
				.build();
		GraphNode gNode = new GraphNode.GraphNodeBuilder()
				.data(6)
				.adjLists(ImmutableList.of(iNode, jNode))
				.build();
		GraphNode cNode = new GraphNode.GraphNodeBuilder()
				.data(2)
				.adjLists(ImmutableList.of(fNode, gNode))
				.build();
		GraphNode bNode = new GraphNode.GraphNodeBuilder()
				.data(1)
				.adjLists(ImmutableList.of(dNode, eNode))
				.build();
		
		// root node
		GraphNode aNode = new GraphNode.GraphNodeBuilder()
				.data(0)
				.adjLists(ImmutableList.of(bNode, cNode))
				.build();
		return aNode;
		 
	}
	
	public static GraphNode cyclicGraph() {
		GraphNode aNode = new GraphNode.GraphNodeBuilder().data(0).build();
		GraphNode bNode = new GraphNode.GraphNodeBuilder().data(1).adjLists(ImmutableList.of(aNode)).build();
		GraphNode cNode = new GraphNode.GraphNodeBuilder().data(2).adjLists(ImmutableList.of(bNode)).build();
		GraphNode a1Node = new GraphNode.GraphNodeBuilder().data(0).adjLists(ImmutableList.of(cNode)).build();
		
		return a1Node;
	}
	
	public static GraphNode selfCyclic() {
		GraphNode aNode = new GraphNode.GraphNodeBuilder().data(0).build();
		GraphNode a1Node = new GraphNode.GraphNodeBuilder().data(0).adjLists(ImmutableList.of(aNode)).build();
		return a1Node;
	}

}
