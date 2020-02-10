package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.service.MutantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MutantServiceImplTest extends MutantServiceImpl {

	private static String[] mutant_dna_1, mutant_dna_2, is_not_mutant_dna_1, is_not_mutant_dna_2;

	@Autowired
	MutantService mutantService;

	@BeforeEach
	void setUp() {
		mutant_dna_1 = new String[]{
				"AGACTA",
				"ATGTTA",
				"CGAGAA",
				"AGACTA",
				"CGACTT",
				"AGGGTT"
		};

		mutant_dna_2 = new String[]{
				"TGACTA",
				"ATGTTA",
				"CGTGAA",
				"ATACTA",
				"CGACTT",
				"AGGGTT"
		};

		is_not_mutant_dna_1 = new String[]{
				"TGAC",
				"ATGT",
				"CGTG",
				"ATAC"
		};

		is_not_mutant_dna_2 = new String[]{
				"CGAC",
				"ATGT",
				"CGTC",
				"ATAC"
		};
	}

	@Test
	void testIsMutant_1() {
		assertTrue(mutantService.isMutant(mutant_dna_1));
	}

	@Test
	void testIsMutant_2() {
		assertTrue(mutantService.isMutant(mutant_dna_2));
	}

	@Test
	void testIsNotMutant_1() {
		assertFalse(mutantService.isMutant(is_not_mutant_dna_1));
	}

	@Test
	void testIsNotMutant_2() {
		assertFalse(mutantService.isMutant(is_not_mutant_dna_2));
	}
}