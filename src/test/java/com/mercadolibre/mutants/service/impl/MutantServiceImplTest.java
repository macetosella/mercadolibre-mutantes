package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.repository.HumanRepository;
import com.mercadolibre.mutants.repository.MutantRepository;
import com.mercadolibre.mutants.service.FindDnaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@DataMongoTest
class MutantServiceImplTest {

	private static String[] mutant_dna_1, mutant_dna_2, is_not_mutant_dna_1, is_not_mutant_dna_2, error_dna;

	@MockBean
	private MutantRepository mutantRepository;

	@MockBean
	private HumanRepository humanRepository;

	@BeforeEach
	void setUp() {
		mutant_dna_1 = new String[]{
				"AAAA",
				"GGGG",
				"AAAA",
				"AAAA",

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

		error_dna = new String[]{
				"AGACTA",
				"AGGGTT"
		};
	}

	@Test
	void testIsMutant_1() {
		FindDnaService findDnaService = new FindDnaAlgorithmServiceImpl();
		MutantServiceImpl mutantServiceImpl = new MutantServiceImpl(findDnaService, mutantRepository, humanRepository);
		assertTrue(mutantServiceImpl.isMutant(mutant_dna_1));
	}

	@Test
	void testIsMutant_2() {
		FindDnaService findDnaService = new FindDnaAlgorithmServiceImpl();
		MutantServiceImpl mutantServiceImpl = new MutantServiceImpl(findDnaService, mutantRepository, humanRepository);
		assertTrue(mutantServiceImpl.isMutant(mutant_dna_2));
	}

	@Test
	void testIsNotMutant_1() {
		FindDnaService findDnaService = new FindDnaAlgorithmServiceImpl();
		MutantServiceImpl mutantServiceImpl = new MutantServiceImpl(findDnaService, mutantRepository, humanRepository);
		assertFalse(mutantServiceImpl.isMutant(is_not_mutant_dna_1));
	}

	@Test
	void testIsNotMutant_2() {
		FindDnaService findDnaService = new FindDnaAlgorithmServiceImpl();
		MutantServiceImpl mutantServiceImpl = new MutantServiceImpl(findDnaService, mutantRepository, humanRepository);
		assertFalse(mutantServiceImpl.isMutant(is_not_mutant_dna_2));
	}

	@Test
	void testIsMutantError() {
		FindDnaService findDnaService = new FindDnaAlgorithmServiceImpl();
		MutantServiceImpl mutantServiceImpl = new MutantServiceImpl(findDnaService, mutantRepository, humanRepository);
		assertFalse(mutantServiceImpl.isMutant(error_dna));
	}


}