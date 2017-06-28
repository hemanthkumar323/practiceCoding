package com.coding.practice.graphs;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.interviewbit.com/problems/smallest-multiple-with-0-and-1/
 * @author Hemanth
 *
 */
public class SmallestMultipleWith0And1s {
	
	public String multiple(int A) {
		BigInteger ele = BigInteger.valueOf(A);
		Queue<BigInteger> q = new LinkedList<BigInteger>();
		q.add(BigInteger.ONE);
		while(true) {
			BigInteger currentEle = q.poll();
			if(currentEle.mod(ele).intValue() == 0)
				return currentEle.toString();
			BigInteger currentEleTimes10  = currentEle.multiply(BigInteger.valueOf(10));
			q.add(currentEleTimes10);
			q.add(currentEleTimes10.add(BigInteger.ONE));
		}
    }

}
