package com.coding.practice.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.coding.practice.util.Utils;

public class TripletSumInRangeBetween0And1 {

	class DoubleClassComparator implements Comparator<Double> {
		public int compare(Double d1, Double d2) {
			if (d1 > d2)
				return 1;
			else
				return -1;
		}
	}

	/**
	 * 
	 * ArrayList 0 - range X: (0, 2/3) 
	 * ArrayList 1 - range Y: [2/3, 1)  
	 * ArrayList 2 - range Z: [1, 2) 
	 * 
	 * Possible feasible solutions 
	 * case 1: X,Y,Z - implicitly <2, check >1 
	 * case 2: X,X,Y 
	 * case 3: X,X,Z - implicitly greater than 1. Check <2
	 * case 4: X,Y,Y - implicitly greater than 1. Check <2 
	 * case 5: X,Y,Z - implicitly greater than 1. Check <2
	 * 
	 * To handle case 2
	 * 
	 * ArrayList 3 - range X1: (0, 1/2)
	 * ArrayList 4 - range X2: [1/2, 2/3)
	 * ArrayList 1 - range Y: [2/3, 1)
	 * 
	 * Possible feasible solutions -
	 * case 1 : X1,X2,Y - implicitly greater than 1. Check <2
	 * case 2 : X1,X1,Y - implicitly < 2. Check >1
	 * case 3 : X2,X2,Y - implicitly greater than 1. Check <2
	 * 
	 * Finally,
	 * |X| >= 3 and Xmax(1) + Xmax(2) + Xmax(3) >= 1
	 * |X| >= 2, |Z| >= 1, and Xmin(1)+Xmin(2)+Zmin(1) <= 2
	 * |X| >= 1, |Y| >= 2, and Xmin(1)+Ymin(1)+Ymin(2) <= 2
	 * |X| >= 1, |Y| >= 1, |Z| >= 1, and Xmin(1)+Ymin(1)+Zmin(1) <= 2
	 * |X| >= 2, |Y| >= 1, and Xmax(1) + Xmax(2) + Ymin(1) < 2
	 * |X| >= 2, |Y| >= 1, and Xmin(1) + Xmin(2) + Ymax(1) > 1
	 * 
	 */
	// Array - un-sorted list
	public boolean process(ArrayList<String> A) {
		int len = A.size();
		
		ArrayList<Double> xList = new ArrayList<Double>();
		ArrayList<Double> yList = new ArrayList<Double>();
		ArrayList<Double> zList = new ArrayList<Double>();
		
		for(int i=0;i<len;i++) {
			
			Double temp = Double.parseDouble(A.get(i));
			if(temp > 0 && temp < (2.0/3.0)) {
				xList.add(temp);
			} else if(temp >= (2.0/3) && temp < 1) {
				yList.add(temp);
			} else if(temp>=1 && temp < 2) {
				zList.add(temp);
			}
			
		}
		
		int xLen = xList.size();
		int yLen = yList.size();
		int zLen = zList.size();
		double zMin = Double.MAX_VALUE, y1Min = Double.MAX_VALUE, y2Min = Double.MAX_VALUE, y1Max = Double.MIN_VALUE;
		
		for(int i=0; i<zLen; i++) {
			double temp = zList.get(i);
			if(zMin > temp) 
				zMin = temp;
		}
		
		for(int i=0; i<yLen; i++) {
			double temp = yList.get(i);
			if(y1Min > temp)
				y1Min = temp;
			if(y1Max < temp)
				y1Max = temp;
		}
		
		boolean isY1Processed = false;
		for(int i=0; i<yLen; i++) {
			double temp = yList.get(i);
			if(y2Min > temp && (isY1Processed || temp!=y1Min))
				y2Min = temp;
			if(temp == y1Min)
				isY1Processed = true;
		}
		
		Collections.sort(xList, new DoubleClassComparator());
		
		if(xLen >= 3) {
			double max1 = xList.get(xLen-1);
			double max2 = xList.get(xLen-2);
			double max3 = xList.get(xLen-3);
			
			if(max1 + max2 + max3 > 1)
				return true;
		}
		
		if(xLen >=2) {
			double min1 = xList.get(0);
			double min2 = xList.get(1);
			
			double max1 = xList.get(xLen-1);
			double max2 = xList.get(xLen-2);
			
			if(zLen>=1 && min1 + min2 + zMin < 2)
				return true;
			
			double maxXSum = max1+ max2;
			for(int i=0;i<yLen;i++) {
				if(maxXSum + yList.get(i) > 1 && maxXSum + yList.get(i) < 2)
					return true;
			}
		}
		
		if(xLen >=1) {
			double min1 = xList.get(0);
			
			if(yLen>=2 && min1 + y1Min + y2Min < 2)
				return true;
			
			if(yLen>=1 && zLen>=1 && min1 + y1Min + zMin <2) 
				return true;
		}
		return false;
	}

	public static void main(String args[]) {
		String arr[] = { ".2", ".5", ".35", "1.4", "2.75" };
		TripletSumInRangeBetween0And1 x = new TripletSumInRangeBetween0And1();
		System.out.println(x.process((ArrayList<String>)Utils.getStringListFromArray(arr)));
	}

	public void print(ArrayList<String> list) {
		int len = list.size();
		for (int i = 0; i < len; i++) {
			System.out.println(list.get(i));
		}
	}

}
