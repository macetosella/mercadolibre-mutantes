package com.mercadolibre.mutants.service;

import com.mercadolibre.mutants.exceptions.MutantException;

public interface FindDnaService {
	Boolean dnaAnalyzer(String[] dna) throws MutantException;
}
