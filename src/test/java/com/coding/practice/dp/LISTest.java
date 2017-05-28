package com.coding.practice.dp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import com.coding.practice.knapsack.CoinChange;

public class LISTest {
	LIS sub = new LIS();
	
	int vals[] = {1,2,3,2,1,5,6,7};
	
	@Test
	public void maxValue() {
		assertThat(sub.length(vals)).isEqualTo(6);
	}

}
