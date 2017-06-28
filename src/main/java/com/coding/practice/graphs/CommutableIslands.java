package com.coding.practice.graphs;

import java.util.ArrayList;
import java.util.Collections;

import com.coding.practice.util.Utils;

/**
 * https://www.interviewbit.com/problems/commutable-islands/
 * @author Hemanth
 *
 */
public class CommutableIslands {
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
			for (int i = 0; i <= vertices; i++) {
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
	
	
	public static void main(String args[]) {
		int arr1[] = {1,2,1};
		int arr2[] = {2,3,4};
		int arr3[] = {1,4,3};
		int arr4[] = {4,3,2};
		int arr5[] = {1,3,10};
		
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		output.add((ArrayList<Integer>)Utils.getListFromArray(arr1));
		output.add((ArrayList<Integer>)Utils.getListFromArray(arr2));
		output.add((ArrayList<Integer>)Utils.getListFromArray(arr3));
		output.add((ArrayList<Integer>)Utils.getListFromArray(arr4));
		output.add((ArrayList<Integer>)Utils.getListFromArray(arr5));
		
		
		CommutableIslands islands = new CommutableIslands();
		System.out.println(islands.solve(4, output));
	}
	
}
