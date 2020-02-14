package com.mercadolibre.mutants.resource;

import com.mercadolibre.mutants.dto.StatDTO;
import com.mercadolibre.mutants.exception.MutantException;
import com.mercadolibre.mutants.service.StatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/V1")
public class StatResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(MutantResource.class);

	@Autowired
	private StatService statService;

	@GetMapping(value = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
	public StatDTO stats() throws MutantException {
		LOGGER.info("REQUEST to stats service invoked to retrieve statistics");

		return statService.stats();
	}
}
