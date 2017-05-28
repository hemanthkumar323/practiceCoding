package com.coding.practice.graphs;

import java.util.List;
import java.util.Objects;

import com.google.common.collect.ImmutableList;

import lombok.Getter;

public class GraphNode {
	private int DATA;
	private List<GraphNode> ADJ_LISTS;

	  private GraphNode(GraphNodeBuilder builder) {
		  this.DATA = builder.DATA;
			this.ADJ_LISTS =  (List<GraphNode>) (Objects.isNull(builder.ADJ_LISTS) 
					? ImmutableList.of() : ImmutableList.copyOf(builder.ADJ_LISTS));
	  }
	  
	  public int data() {
		  return DATA;
	  }
	  
	  public List<GraphNode> adjLists() {
		  return ADJ_LISTS;
	  }

	  public static class GraphNodeBuilder {
		  private int DATA;
		  private List<GraphNode> ADJ_LISTS;		  

	    public GraphNodeBuilder data(int data) {
	    	this.DATA = data;
	      return this;
	    }

	    public GraphNodeBuilder adjLists(List<GraphNode> adjLists) {
	    	this.ADJ_LISTS = adjLists;
	      return this;
	    }

	    public GraphNode build() {
	      return new GraphNode(this);
	    }

	  }
	}