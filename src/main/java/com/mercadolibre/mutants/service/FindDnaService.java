package com.mercadolibre.mutants.service;

import com.mercadolibre.mutants.exception.MutantException;

public interface FindDnaService {
	Boolean dnaAnalyzer(String[] dna) throws MutantException;
}
