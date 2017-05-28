package com.coding.practice.knapsack;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class CoinChangeTest {
	
	int vals[] = {1,2,3};
	CoinChange sub = new CoinChange();
	
	@Test
	public void maxValue() {
		assertThat(sub.possibleCoinChange(vals, 4)).isEqualTo(4);
	}
	

}
