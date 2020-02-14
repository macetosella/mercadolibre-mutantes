package com.mercadolibre.mutants.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "human")
public class Human extends Person {

	public Human(String[] dna) {
		super(dna);
	}
}
