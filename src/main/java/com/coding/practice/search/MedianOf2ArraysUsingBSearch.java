package com.coding.practice.search;

import java.util.List;

import com.coding.practice.util.Utils;

public class MedianOf2ArraysUsingBSearch {

	// With Arrays
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int total = nums1.length+nums2.length;
	    if(total%2==0){
	        return (findKth(total/2+1, nums1, nums2, 0, 0)+findKth(total/2, nums1, nums2, 0, 0))/2.0;
	    }else{
	        return findKth(total/2+1, nums1, nums2, 0, 0);
	    }
	}
	 
	public int findKth(int k, int[] nums1, int[] nums2, int s1, int s2){
	    if(s1>=nums1.length)
	        return nums2[s2+k-1];
	 
	    if(s2>=nums2.length)
	        return nums1[s1+k-1];
	 
	    if(k==1)
	        return Math.min(nums1[s1], nums2[s2]);
	 
	    int m1 = s1+k/2-1;
	    int m2 = s2+k/2-1;
	 
	    int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;    
	    int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;
	 
	    if(mid1<mid2){
	        return findKth(k-k/2, nums1, nums2, m1+1, s2);
	    }else{
	        return findKth(k-k/2, nums1, nums2, s1, m2+1);
	    }
	}
	
	public double findMedianSortedArrays(List<Integer> nums1, List<Integer> nums2) {
	    int total = nums1.size()+nums2.size();
	    if(total%2==0){
	        return (findKth(total/2+1, nums1, nums2, 0, 0)+findKth(total/2, nums1, nums2, 0, 0))/2.0;
	    }else{
	        return findKth(total/2+1, nums1, nums2, 0, 0);
	    }
	}
	
	public int findKth(int k, List<Integer> nums1, List<Integer> nums2, int s1, int s2){
	    if(s1>=nums1.size())
	        return nums2.get(s2+k-1);
	 
	    if(s2>=nums2.size())
	        return nums1.get(s1+k-1);
	 
	    if(k==1)
	        return Math.min(nums1.get(s1), nums2.get(s2));
	 
	    int m1 = s1+k/2-1;
	    int m2 = s2+k/2-1;
	 
	    int mid1 = m1<nums1.size()?nums1.get(m1):Integer.MAX_VALUE;    
	    int mid2 = m2<nums2.size()?nums2.get(m2):Integer.MAX_VALUE;
	 
	    if(mid1<mid2){
	        return findKth(k-k/2, nums1, nums2, m1+1, s2);
	    }else{
	        return findKth(k-k/2, nums1, nums2, s1, m2+1);
	    }
	}
	public static void main(String args[]) {
		int arr1[] = {-50, -41, -40, -19, 5, 21, 28};
		int arr2[] = { -50, -21, -10 };
		List<Integer> list1 = Utils.getListFromArray(arr1);
		List<Integer> list2 = Utils.getListFromArray(arr2);
		MedianOf2ArraysUsingBSearch med = new MedianOf2ArraysUsingBSearch();
		System.out.println(med.findMedianSortedArrays(list1, list2));
	}

}
