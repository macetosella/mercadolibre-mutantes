package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.exceptions.MutantException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	void testDnaAnalyzerMutant() throws MutantException {
		assertTrue(dnaAnalyzer(mutant_dna));
	}

	@Test
	void testDnaAnalyzerWithError() {
		assertThrows(MutantException.class, () -> {
			dnaAnalyzer(error_dna);
		});
	}
}