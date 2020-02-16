package com.mercadolibre.mutants.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.mutants.dto.DnaSequenceDTO;
import com.mercadolibre.mutants.service.MutantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MutantResource.class)
class MutantResourceTest {


	@Autowired
	private MockMvc mockMvc;

	private String[] mutantDna;
	private String[] humanDna;

	@MockBean
	MutantService mutantService;


	@BeforeEach
	void setUp() {
		mutantDna = new String[]{"AAAAAA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTT"};
		humanDna = new String[]{
				"CGAC",
				"ATGT",
				"CGTC",
				"ATAC"
		};
	}

	@Test
	void testIsMutantResource_200() throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		String dna = mapper.writeValueAsString(new DnaSequenceDTO(mutantDna));

		when(mutantService.isMutant(mutantDna)).thenReturn(Boolean.TRUE);

		mockMvc.perform(MockMvcRequestBuilders.post("/V1/mutant")
				.contentType(MediaType.APPLICATION_JSON)
				.content(dna))
				.andExpect(status().isOk());
	}

	@Test
	void testIsMutantResource_403() throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		String dna = mapper.writeValueAsString(new DnaSequenceDTO(humanDna));

		when(mutantService.isMutant(humanDna)).thenReturn(Boolean.FALSE);

		mockMvc.perform(MockMvcRequestBuilders.post("/V1/mutant")
				.contentType(MediaType.APPLICATION_JSON)
				.content(dna))
				.andExpect(status().is4xxClientError());
	}
}