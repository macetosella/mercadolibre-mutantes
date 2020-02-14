package com.mercadolibre.mutants.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mutant")
public class Mutant extends Person {

	public Mutant(String[] dna) {
		super(dna);
	}
}
