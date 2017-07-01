package com.coding.practice.graphs;

import java.util.ArrayList;
import java.util.Collections;

/**
 * MST Kruskal algorithm 
 * 
 * a. Sort all edges by weights. 
 * 
 * b. Pick the smallest
 * weighted edge. Check if that forms a cycle. If not, include the edge 
 * 
 * c.Continue until we pick V-1 edges for a V vertex graph
 * 
 * Step b is done using Disjoint Set data-structure.
 * 
 * @author challh
 *
 */
public class MinimumSpanningTree {

	class DisjointSetElement {
		int parent;
		int rank;

		DisjointSetElement(int parent, int rank) {
			this.parent = parent;
			this.rank = rank;
		}

	}

	class Edge implements Comparable<Edge> {
		int src, dest, weight;
		
		Edge(int src,int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		public int compareTo(Edge anotherEdge) {
			return this.weight - anotherEdge.weight;
		}
	}

	class DisjointSetHelper {

		public int find(ArrayList<DisjointSetElement> disjointSets, int x) {
			if (disjointSets.get(x).parent != x) {
				disjointSets.get(x).parent = find(disjointSets, disjointSets.get(x).parent);
			}
			return disjointSets.get(x).parent;
		}

		public void union(ArrayList<DisjointSetElement> disjointSets, int x, int y) {
			int x_parent = find(disjointSets, x);
			int y_parent = find(disjointSets, y);

			// They are already under same parent
			if (x_parent == y_parent)
				return;

			if (disjointSets.get(x_parent).rank < disjointSets.get(y_parent).rank) {
				disjointSets.get(x_parent).parent = y_parent;
			} else if (disjointSets.get(y_parent).rank < disjointSets.get(x_parent).rank) {
				disjointSets.get(y_parent).parent = x_parent;
			} else {
				disjointSets.get(y_parent).parent = x_parent;
				disjointSets.get(x_parent).rank = disjointSets.get(x_parent).rank + 1;
			}

		}
	}

	// retrieves the Minimum Spanning Tree for the list of edges and given
	// vertices count.
	public ArrayList<Edge> getMST(ArrayList<Edge> edges, int vertices) {
		ArrayList<Edge> edgesInMST = new ArrayList<Edge>();
		int size = edges.size();
		if (size != 0) {
			DisjointSetHelper setHelper = new DisjointSetHelper();
			ArrayList<DisjointSetElement> disjointSetList = new ArrayList<DisjointSetElement>();
			for (int i = 0; i < vertices; i++) {
				disjointSetList.add(new DisjointSetElement(i, 1));
			}

			int totalEdges = 0, currentEdge=0;
			// Sort edges by weight
			Collections.sort(edges);

			while (totalEdges < vertices - 1) {
				Edge temp = edges.get(currentEdge++);

				int src_parent = setHelper.find(disjointSetList, temp.src);
				int dest_parent = setHelper.find(disjointSetList, temp.dest);

				// This edge doesn't form a cycle
				if (src_parent != dest_parent) {
					// Add this edge to the result.
					edgesInMST.add(temp);
					totalEdges++;
					setHelper.union(disjointSetList, src_parent, dest_parent);

				}

			}
		}
		return edgesInMST;
	}
	
	public void printEdges(ArrayList<Edge> edges) {
		int size = edges.size();
		for(int i=0; i<size; i++) {
			System.out.println(edges.get(i).src + " " + edges.get(i).dest + " " + edges.get(i).weight);
		}
	}
	
	public static void main(String args[]) {
		int src[] = {0,1,0,0,2};
		int dest[] = {1,3,3,2,3};
		int weights[] = {10,15,5,6,4};
		int vertices = 4;
		MinimumSpanningTree m = new MinimumSpanningTree();
		ArrayList<Edge> output = m.getMST(m.buildInputData(src, dest, weights), vertices);
		m.printEdges(output);
	}
	
	public int solve(int A, ArrayList<ArrayList<Integer>> B) {
		if(B == null || A == 0)
			return 0;
		ArrayList<Edge> output = getMST(buildInputData(B), A);
		int result = 0;
		for(int i=0; i<output.size(); i++) {
			result += output.get(i).weight;
		}
		return result;
    }
	
	public ArrayList<Edge> buildInputData(ArrayList<ArrayList<Integer>> input) {
		int size = input.size();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i=0; i< size; i++) {
			edges.add(new Edge(input.get(i).get(0), input.get(i).get(1), input.get(i).get(2)));
		}
		return edges;	
	}
	
	public ArrayList<Edge> buildInputData(int src[], int dest[], int weights[]) {
		int size = src.length;
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i=0; i< size; i++) {
			edges.add(new Edge(src[i], dest[i], weights[i]));
		}
		return edges;
	}
	
	
}
