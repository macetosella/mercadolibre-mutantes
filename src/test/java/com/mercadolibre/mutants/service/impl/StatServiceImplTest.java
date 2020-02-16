package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.repository.HumanRepository;
import com.mercadolibre.mutants.repository.MutantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@DataMongoTest
class StatServiceImplTest {

	@MockBean
	private MutantRepository mutantRepository;

	@MockBean
	private HumanRepository humanRepository;

	@Test
	void stats() {
		when(mutantRepository.count()).thenReturn(31L);
		when(humanRepository.count()).thenReturn(3L);
		StatServiceImpl statService = new StatServiceImpl(mutantRepository, humanRepository);

		assertEquals(10.33, statService.stats().getRatio());
	}

}