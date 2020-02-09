package com.mercadolibre.mutants;

import com.mercadolibre.mutants.service.MutantService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MutantsApplicationTests {

	@Autowired
	MutantService mutantService;

	private static String[] mutant_dna;

	@BeforeAll
	static void init() {
		mutant_dna = new String[]{
				"RRRRRA",
				"RRRRAR",
				"RRRART",
				"RRARRT",
				"RTRRRT",
				"RRRRRT"
		};
	}

	@Test
	void isMutantTest() {
		assertTrue(mutantService.isMutant(mutant_dna));
	}

}
