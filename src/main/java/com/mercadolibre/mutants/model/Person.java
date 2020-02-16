package com.mercadolibre.mutants.model;

import org.springframework.data.annotation.Id;

public abstract class Person {

	public Person(String[] dna) {
		this.setDna(String.join(",", dna));
	}

	public Person() {
	}

	@Id
	protected String dna;

	public String getDna() {
		return dna;
	}

	public void setDna(String dna) {
		this.dna = dna;
	}
}
