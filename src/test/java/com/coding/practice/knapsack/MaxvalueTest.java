package com.coding.practice.knapsack;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class MaxvalueTest {
	int wts[] = {3,5,7,4,10,15};
	int vals[] = {15,2,5,9,13, 3};
	
	MaxValue sub = new MaxValue();
	
	@Test
	public void maxValue() {
		assertThat(sub.maxValue(wts, vals, 8)).isEqualTo(24);
	}
	

}
