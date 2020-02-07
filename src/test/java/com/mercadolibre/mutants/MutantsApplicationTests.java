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

	static String[] dna = {"asdasd", "asdasd"};

	@BeforeAll
	public static void init() {

	}

	@Test
	void isMutantTest() {
		assertEquals(mutantService.isMutant(dna), true);
	}

}
