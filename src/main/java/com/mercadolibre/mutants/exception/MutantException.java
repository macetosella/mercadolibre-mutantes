package com.mercadolibre.mutants.exception;

public class MutantException extends Exception {

	public MutantException() {
	}

	public MutantException(String message) {
		super(message);
	}

	public MutantException(String message, Throwable cause) {
		super(message, cause);
	}

	public MutantException(Throwable cause) {
		super(cause);
	}

	public MutantException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
