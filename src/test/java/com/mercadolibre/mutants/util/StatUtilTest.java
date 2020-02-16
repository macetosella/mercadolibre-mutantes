package com.mercadolibre.mutants.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatUtilTest {

	@Test
	void calculateRatioWithBigDecimal() {
		double expected = 10.33;
		assertEquals(expected, StatUtil.calculateRatioWithBigDecimal(31L, 3L));
	}
}