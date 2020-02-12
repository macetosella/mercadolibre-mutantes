package com.mercadolibre.mutants.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.mutants.dto.DnaSequenceDTO;
import com.mercadolibre.mutants.exception.MutantException;
import com.mercadolibre.mutants.service.MutantService;
import com.mercadolibre.mutants.service.impl.MutantServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class MutantResourceTest extends MutantResource {

	@Autowired
	private WebApplicationContext appContext;

	private MockMvc mockMvc;
	private DnaSequenceDTO dnaSequenceDTO;

	@Autowired
	public MutantResourceTest(MutantService mutantService) {
		super(mutantService);
	}


	@BeforeEach
	void setUp() {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.appContext).build();

		String[] mutant_dna = new String[]{
				"AGACTA",
				"ATGTTA",
				"CGAGAA",
				"AGACTA",
				"CGACTT",
				"AGGGTT"
		};

		dnaSequenceDTO = new DnaSequenceDTO(mutant_dna);
	}

	@Test
	void testIsMutantResource() throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		String dna = mapper.writeValueAsString(dnaSequenceDTO);

		mockMvc.perform(MockMvcRequestBuilders.post("/V1/mutant")
				.contentType(MediaType.APPLICATION_JSON)
				.content(dna))
				.andExpect(status().isOk());


	}
}