package com.mercadolibre.mutants;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration
class MutantsApplicationTests extends MutantsApplication {


	@Test
	void MutantsApplicationTest() {
		MutantsApplication.main(new String[]{});
	}
}
