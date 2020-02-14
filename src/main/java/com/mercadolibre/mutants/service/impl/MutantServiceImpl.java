package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.exception.MutantException;
import com.mercadolibre.mutants.model.Human;
import com.mercadolibre.mutants.model.Mutant;
import com.mercadolibre.mutants.repository.HumanRepository;
import com.mercadolibre.mutants.repository.MutantRepository;
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

	@Autowired
	MutantRepository mutantRepository;

	@Autowired
	HumanRepository humanRepository;

	@Override
	public Boolean isMutant(String[] dna) {

		Boolean isMutant = false;
		LOGGER.info("Checking if the DNA is from a mutant...");

		try {
			isMutant = findDnaAlgorithmServiceImpl.dnaAnalyzer(dna);
			addToStatistics(dna, isMutant);
		} catch (MutantException e) {
			LOGGER.error("Error analizing DNA:", e);
		}
		return isMutant;
	}

	private void addToStatistics(String[] dna, Boolean isMutant) {
		if (isMutant) {
			Mutant mutant = new Mutant(dna);
			if (!mutantRepository.existsById(mutant.getDna())) {
				mutantRepository.insert(mutant);
				LOGGER.info("New mutant dna was added to statistic: {}", mutant.getDna());
			}
		} else {
			Human human = new Human(dna);
			if (humanRepository.existsById(human.getDna())) {
				humanRepository.insert(human);
				LOGGER.info("New human dna was added to statistic: {}", human.getDna());
			}
		}
	}
}
