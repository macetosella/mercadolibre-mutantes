package com.mercadolibre.mutants.repository;

import com.mercadolibre.mutants.model.Human;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataMongoTest
public class HumanRepositoryTestIntegration {

	@Autowired
	private HumanRepository humanRepository;


	@DisplayName("given object to save"
			+ " when save object using MongoDB embedded"
			+ " then object is saved")
	@Test
	void test() {
		String dna = "TGAC,ATGT,CGTG,TTTT";
		Human human = new Human(new String[]{"TGAC", "ATGT", "CGTG", "TTTT"});
		humanRepository.insert(human);

		assertThat(Objects.requireNonNull(humanRepository.findById(dna).orElse(null)).getDna()).isEqualTo(human.getDna());

	}

}
