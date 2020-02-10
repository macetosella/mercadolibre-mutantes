package com.mercadolibre.mutants.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindDnaAlgorithmServiceImplTest extends FindDnaAlgorithmServiceImpl {

	private static String[] mutant_dna, error_dna;

	@BeforeEach
	void setUp() {
		mutant_dna = new String[]{
				"AGACTA",
				"ATGTTA",
				"CGAGAA",
				"AGACTA",
				"CGACTT",
				"AGGGTT"
		};
		error_dna = new String[]{
				"AGACTA",
				"AGGGTT"
		};
	}

	@Test
	void testDnaAnalyzerMutant() throws Exception {
		assertTrue(dnaAnalyzer(mutant_dna));
	}

	@Test
	void testDnaAnalyzerWithError() throws Exception {

		Exception exception = assertThrows(Exception.class, () -> {
			dnaAnalyzer(error_dna);
		});
	}
}