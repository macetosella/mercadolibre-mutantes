package com.mercadolibre.mutants.dto;


import javax.validation.constraints.NotNull;
import java.util.Arrays;


public class DnaSequenceDTO {

	@NotNull
	private String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	public DnaSequenceDTO() {
	}

	public DnaSequenceDTO(@NotNull String[] dna) {
		this.dna = dna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dna == null) ? 0 : dna.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DnaSequenceDTO)) return false;
		DnaSequenceDTO that = (DnaSequenceDTO) o;
		return getDna().equals(that.getDna());
	}

	@Override
	public String toString() {
		return "DnaSequenceDTO{" +
				"dna=" + Arrays.toString(dna) +
				'}';
	}
}