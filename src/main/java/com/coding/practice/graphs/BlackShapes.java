package com.coding.practice.graphs;

import java.util.ArrayList;

import com.coding.practice.util.Utils;

/**
 * https://www.interviewbit.com/problems/black-shapes/
 * 
 * @author Hemanth
 *
 */
public class BlackShapes {

	public int black(ArrayList<String> a) {
		if (a == null)
			return 0;
		int m = a.size();
		int n = a.get(0).length();
		boolean visited[][] = new boolean[m][n];

		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				String currString = a.get(i);
				if (visited[i][j] == false && currString.charAt(j) == 'X') {
					count++;
					DFS(a, visited, m, n, i, j);
				}
			}
		}
		return count;
	}

	private void DFS(ArrayList<String> a, boolean visited[][], int m, int n, int i, int j) {
		int xpos[] = {0,1,-1,0};
		int ypos[] = {1,0,0,-1};
		visited[i][j] = true;
		for(int x=0; x<4; x++) {
			if(isSafe(m,n, i+xpos[x], j+ypos[x]) && !visited[i+xpos[x]][j+ypos[x]]) {
				String str = a.get(i+xpos[x]);
				if(str.charAt(j+ypos[x]) == 'X') {
					DFS(a, visited, m, n, i+xpos[x], j+ypos[x]);
				}
			}
		}
	}
	
	private boolean isSafe(int m, int n, int i, int j) {
		if(i>=0 && i<m && j>=0 && j<n)
			return true;
		return false;
	}
	
	
	public static void main(String args[]) {
		String arr[] = {"OOOXOOO", "OOXXOXO", "OXOOOXO"};
		BlackShapes b = new BlackShapes();
		System.out.println(b.black((ArrayList<String>)Utils.getStringListFromArray(arr)));
	}

}
