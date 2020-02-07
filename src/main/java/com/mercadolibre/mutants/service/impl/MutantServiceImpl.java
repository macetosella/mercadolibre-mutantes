package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.service.MutantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl implements MutantService {

	private static final Logger logger = LoggerFactory.getLogger(MutantServiceImpl.class);

	@Override
	public boolean isMutant(String[] dna) {
		logger.info("checking if the DNA is from a mutant...");
		return true;
	}
}
