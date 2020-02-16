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

	private DnaSequenceDTO dnaSequenceDTO;
	private String[] mutantDna;

	@MockBean
	MutantService mutantService;


	@BeforeEach
	void setUp() {
		mutantDna = new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTT"};
		dnaSequenceDTO = new DnaSequenceDTO(mutantDna);
	}

	@Test
	void testIsMutantResource() throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		String dna = mapper.writeValueAsString(dnaSequenceDTO);

		when(mutantService.isMutant(mutantDna)).thenReturn(Boolean.TRUE);

		mockMvc.perform(MockMvcRequestBuilders.post("/V1/mutant")
				.contentType(MediaType.APPLICATION_JSON)
				.content(dna))
				.andExpect(status().isOk());


	}
}