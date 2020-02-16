package com.mercadolibre.mutants.resource;

import com.mercadolibre.mutants.service.StatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StatResource.class)
class StatResourceTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	StatService statService;

	@Test
	void testIsStatResource() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/V1/stats")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());


	}
}