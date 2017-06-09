package com.coding.practice.stack;

import java.util.ArrayList;

/**
 * Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
 * More formally,
 * G[i] for an element A[i] = an element A[j] such that 
 *   j is maximum possible AND 
 *   j < i AND
 *  A[j] < A[i]
 * Elements for which no smaller element exist, consider next smaller element as -1.
 * Example:
 * Input : A : [4, 5, 2, 10]
 * Return : [-1, 4, -1, 2]
 * Example 2:
 * Input : A : [3, 2, 1]
 * Return : [-1, -1, -1]
 * @author Hemanth
 *
 */
public class NearestSmallestInteger {

	public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int size = arr.size();
		if (size < 1)
			return result;
		result.add(-1);
		for (int i = 1; i < size; i++) {
			int currEle = arr.get(i);
			int index = i - 1;

			while (index != -1 && currEle > arr.get(index)) {
				index = temp.get(index);
			}
			temp.add(index);
			if (index != -1)
				result.add(arr.get(index));
			else
				result.add(-1);
		}
		return result;
	}
	
	/*
	 vector<int> Solution::prevSmaller(vector<int> &A) {
    vector<int> ans;
    ans.resize(A.size());

    stack<int> st;
    
    for (int i = 0; i < A.size(); i++) {
        while (!st.empty() && st.top() >= A[i]) st.pop();
        if (st.empty()) {
            ans[i] = -1;
        } else {
            ans[i] = st.top();
        }
        st.push(A[i]);
    }
    return ans;
}
	 */

}
