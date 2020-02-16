package com.mercadolibre.mutants;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;


@DataMongoTest(excludeAutoConfiguration = {EmbeddedMongoAutoConfiguration.class})
class MutantsApplicationTests extends MutantsApplication{

	@Test
	public void contextLoads() {
	}
}
