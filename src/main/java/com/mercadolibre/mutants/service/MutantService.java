package com.mercadolibre.mutants.service;

import com.mercadolibre.mutants.exception.MutantException;

public interface MutantService {

	Boolean isMutant(String[] dna) throws MutantException;
}
