package com.mercadolibre.mutants.resource;

import com.mercadolibre.mutants.dto.DnaSequenceDTO;
import com.mercadolibre.mutants.exception.MutantException;
import com.mercadolibre.mutants.service.MutantService;
import com.mercadolibre.mutants.service.impl.MutantServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 *
 */
@Resource
@RestController
@RequestMapping("/V1")
public class MutantResource {

	private static final Logger LOGGER = LogManager.getLogger(MutantServiceImpl.class);

	MutantService mutantService;

	@Autowired
	public MutantResource(MutantService mutantService) {
		this.mutantService = mutantService;
	}

	@PostMapping(path = "/mutant", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> isMutant(@RequestBody @Valid DnaSequenceDTO dna) throws MutantException {
		LOGGER.info("REQUEST to Detects whether a human is a mutant: {}", dna);

		Boolean isMutant = mutantService.isMutant(dna.getDna());
		if (isMutant) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
}
