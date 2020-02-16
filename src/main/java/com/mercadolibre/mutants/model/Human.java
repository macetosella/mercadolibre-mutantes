package com.mercadolibre.mutants.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "human")
public class Human extends Person{

	public Human(String[] dna) {
		super(dna);
	}

	public Human() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Human)) return false;
		Human human = (Human) o;
		return Objects.equals(getDna(), human.getDna());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDna());
	}
}
