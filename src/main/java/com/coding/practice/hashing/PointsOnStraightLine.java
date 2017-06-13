package com.coding.practice.hashing;

import java.util.ArrayList;
import java.util.HashMap;

import com.coding.practice.util.Utils;
// Incomplete Answer
public class PointsOnStraightLine {

	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		int size = a.size();
		if (size != b.size())
			return 0;
		if (size < 2)
			return size;

		// points with same x-coordinates
		int pointsOnVerticalLine;
		int pointsOnHorizontalLine;
		// number of points with same x,y co-ordinates
		int overlappingPoints;
		int currentMax;
		int maxPoints = 0;
		HashMap<ArrayList<Integer>, Integer> slopeMap;
		for (int i = 0; i < size; i++) {
			slopeMap = new HashMap<ArrayList<Integer>, Integer>();
			pointsOnHorizontalLine = pointsOnVerticalLine = overlappingPoints = currentMax = 0;

			for (int j = i + 1; j < size; j++) {

				// x-coordinates are same
				if (a.get(i) == a.get(j)) {
					// y-coordinates are same
					if (b.get(i) == b.get(j))
						overlappingPoints++;
					else
						pointsOnVerticalLine++;
				} else if(b.get(i) == b.get(j)) {
					pointsOnHorizontalLine++;
				} else {
					int x_diff = a.get(i) - a.get(j);
					int y_diff = b.get(i) - b.get(j);
					int gcd = gcd(Math.abs(x_diff), Math.abs(y_diff));
					x_diff = x_diff / gcd;
					y_diff = y_diff / gcd;


					ArrayList<Integer> pt = new ArrayList<Integer>();
					pt.add(x_diff);
					pt.add(y_diff);

					if (slopeMap.containsKey(pt)) {
						int count = slopeMap.get(pt);
						slopeMap.put(pt, count + 1);
					} else {
						slopeMap.put(pt, 1);
					}
					currentMax = max(currentMax, slopeMap.get(pt));
				}
				currentMax = max(currentMax, max(pointsOnVerticalLine, pointsOnHorizontalLine));
			}
			maxPoints = max(maxPoints, currentMax + overlappingPoints + 1);

		}

		return maxPoints;

	}

	private int gcd(int x, int y) {
		if(x == 0 || y == 0)
			return 0;
		if(x == y)
			return x;
		if(x > y)
			return gcd(x-y, y);
		return gcd(x, y-x);
		
		
	}

	private int max(int x, int y) {
		return x > y ? x : y;
	}

	public static void main(String args[]) {
		int arr1[] = { -6,5,-18, 2, 5, 2 };
		int arr2[] = { -17,-16,-17, -4, -13,20 };
		PointsOnStraightLine points = new PointsOnStraightLine();
		System.out.println(points.maxPoints((ArrayList<Integer>) Utils.getListFromArray(arr1),
				(ArrayList<Integer>) Utils.getListFromArray(arr2)));
	}

}
