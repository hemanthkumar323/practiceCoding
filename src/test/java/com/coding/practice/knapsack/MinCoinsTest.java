package com.coding.practice.knapsack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MinCoinsTest {
	int vals[] = {1,2,3,4};
	MinCoins sub = new MinCoins();
	
	@Test
	public void maxValue() {
		assertThat(sub.minCoins(vals, 7)).isEqualTo(2);
	}
}
