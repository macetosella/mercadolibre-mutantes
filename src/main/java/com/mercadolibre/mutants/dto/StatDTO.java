package com.mercadolibre.mutants.dto;

import java.io.Serializable;

public class StatDTO implements Serializable {


	private static final long serialVersionUID = -2357866120705174050L;
	private long countMutantDna;
	private long countHumanDna;
	private double ratio;

	public StatDTO() {
	}

	public StatDTO(long mutants, long humans, double ratio) {
		this.countMutantDna = mutants;
		this.countHumanDna = humans;
		this.ratio = ratio;
	}

	public String toString() {
		return "[mutants: " + countMutantDna + ", humans: " + countHumanDna + ", ratio: " + ratio + "]";
	}

	public long getCountMutantDna() {
		return countMutantDna;
	}

	public void setCountMutantDna(long countMutantDna) {
		this.countMutantDna = countMutantDna;
	}

	public long getCountHumanDna() {
		return countHumanDna;
	}

	public void setCountHumanDna(long countHumanDna) {
		this.countHumanDna = countHumanDna;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
}