package com.mercadolibre.mutants.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "mutant")
public class Mutant extends Person {

	public Mutant(String[] dna) {
		super(dna);
	}

	public Mutant() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Mutant)) return false;
		Mutant mutant = (Mutant) o;
		return Objects.equals(getDna(), mutant.getDna());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDna());
	}
}
