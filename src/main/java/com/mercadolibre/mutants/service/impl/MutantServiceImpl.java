package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.exception.MutantException;
import com.mercadolibre.mutants.service.FindDnaService;
import com.mercadolibre.mutants.service.MutantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl implements MutantService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MutantServiceImpl.class);

	@Autowired
	FindDnaService findDnaAlgorithmServiceImpl;

	@Override
	public Boolean isMutant(String[] dna) throws MutantException {

		Boolean isMutant = false;
		LOGGER.info("Checking if the DNA is from a mutant...");

		try {
			isMutant = findDnaAlgorithmServiceImpl.dnaAnalyzer(dna);
		} catch (MutantException e) {
			LOGGER.error("Error analizing DNA:", e);
		}
		return isMutant;
	}
}
