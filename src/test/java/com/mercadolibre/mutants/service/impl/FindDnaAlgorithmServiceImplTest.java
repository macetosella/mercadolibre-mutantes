package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.exception.MutantException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FindDnaAlgorithmServiceImplTest extends FindDnaAlgorithmServiceImpl {

	private static String[] mutant_dna, error_dna, error_dna2, empty_dna;

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

		error_dna2= new String[]{
				"AGAC",
				"SSSS",
				"CACA",
				"GGGG"
		};

		empty_dna = new String[]{};
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

	@Test
	void testDnaAnalyzerWithEmpty() {
		assertThrows(MutantException.class, () -> {
			dnaAnalyzer(empty_dna);
		});
	}

	@Test
	void testDnaAnalyzerWithError2() {
		assertThrows(MutantException.class, () -> {
			dnaAnalyzer(error_dna2);
		});
	}
}