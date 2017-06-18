package com.coding.practice.greedy;

import java.util.AbstractMap;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://www.interviewbit.com/problems/seats/
 * @author Hemanth
 *
 */
public class Seats {
	
	public int seats(String a) {
		Deque<Map.Entry<Integer, Integer>> deque = new LinkedList<Map.Entry<Integer, Integer>>();
	    int size = a.length();
	    int i = 0 , start =-1, end = -1, count = 0;
	    
	    while(i<size) {
	    	while(i<size && a.charAt(i) == '.')
	    		i++;
	    	if(i == size)
	    		break;
	    	start = i;
	    	while(i<size && a.charAt(i) == 'x')
	    		i++;
	    	end = i;
	    	
	    	deque.add(new AbstractMap.SimpleEntry<Integer, Integer>(start, end-1));
	    	
	    }
	    
	    System.out.println(deque);
	    while(deque.size() > 1) {
	    	
	    	Map.Entry<Integer, Integer> left = deque.peekFirst();
	    	Map.Entry<Integer, Integer> right = deque.peekLast();
	    	
	    	int lenLeft = left.getValue() - left.getKey() + 1;
	    	int lenRight = right.getValue() - right.getKey() + 1;
	    	
	    	if(lenLeft <= lenRight) {
	    		left = deque.pollFirst();
	    		count +=lenLeft * (deque.peekFirst().getKey() - left.getValue() - 1);
	    		Map.Entry<Integer, Integer> temp = deque.pollFirst();
	    		deque.addFirst(new AbstractMap.SimpleEntry<Integer, Integer>(temp.getKey() - lenLeft, temp.getValue()));
	    	} else {
	    		right = deque.pollLast();
	    		count += lenRight * (right.getKey() - deque.peekLast().getValue() - 1);
	    		Map.Entry<Integer, Integer> temp = deque.pollLast();
	    		deque.addLast(new AbstractMap.SimpleEntry<Integer, Integer>(temp.getKey(), temp.getValue() + lenRight));
	    		
	    	}
	    	
	    	
	    }
	    return count;
	}
	
	public static void main(String args[]) {
		String x = "....x..xx...x..";
		Seats s = new Seats();
		System.out.println(s.seats(x));
	}

}
