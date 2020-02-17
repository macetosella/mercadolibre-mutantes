package com.mercadolibre.mutants.exception;

public class MutantException extends Exception {

	private static final long serialVersionUID = 7000181794403478325L;

	public MutantException() {
	}

	public MutantException(String message) {
		super(message);
	}

	public MutantException(String message, Throwable cause) {
		super(message, cause);
	}
}
