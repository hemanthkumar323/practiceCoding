package com.coding.practice.dp;

import java.util.ArrayList;

import com.coding.practice.util.Utils;

public class CoinSumInfinite {
	
	public int coinchange2(ArrayList<Integer> a, int b) {
		int mod = 1000007;
		if(a == null)
			return 0;
		//ArrayList<Integer> dp = new ArrayList<Integer>();
		int dp[] = new int[b+1];
		dp[0] = 1;
		int length = a.size();
		for(int i=0; i < length; i++) {
			int ele = a.get(i);
			for(int j = ele; j<=b; j = j+=1) {
				dp[j] = dp[j] % mod + dp[j-ele] % mod;
				dp[j] = dp[j] % mod;
			}
		}
		return dp[b];
    }
	
	public static void main(String args[]) {
		int arr[] = {1,2,3}
;		CoinSumInfinite sum = new CoinSumInfinite();
		System.out.println(sum.coinchange2((ArrayList<Integer>)Utils.getListFromArray(arr), 4));
	}

}
