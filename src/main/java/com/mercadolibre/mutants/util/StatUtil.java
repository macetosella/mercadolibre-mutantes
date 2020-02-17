package com.mercadolibre.mutants.util;

import java.math.BigDecimal;


public class StatUtil {

	public static double calculateRatioWithBigDecimal(final Long mutantCount, final Long humanCount) {
		BigDecimal ratio = BigDecimal.ZERO;
		if (humanCount > 0) {
			ratio = new BigDecimal(mutantCount).divide(new BigDecimal(humanCount), 2, BigDecimal.ROUND_HALF_UP);
		}
		return ratio.doubleValue();
	}
}
