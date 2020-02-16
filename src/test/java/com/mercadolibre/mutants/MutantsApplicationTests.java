package com.mercadolibre.mutants;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataMongoTest(excludeAutoConfiguration = {EmbeddedMongoAutoConfiguration.class})
class MutantsApplicationTests extends MutantsApplication{

	@Test
	public void contextLoads() {
	}

	@Test
	public void mutantsApplication(){
		MutantsApplication.main(new String[]{});
	}
}
