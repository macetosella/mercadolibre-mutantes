package com.mercadolibre.mutants.service;

import com.mercadolibre.mutants.exceptions.MutantException;

public interface MutantService {

	Boolean isMutant(String[] dna) throws MutantException;
}
