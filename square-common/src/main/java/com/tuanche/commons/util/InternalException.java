package com.tuanche.commons.util;

public class InternalException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public InternalException(String message) {
		this.message = message;
	}

	public InternalException(Exception e) {
		super(e);
	}

	public InternalException(String message, Exception e) {
		super(e);
		this.message = message;
	}

	public String getMessage() {
		if (this.message != null) {
			return this.message;
		}
		return super.getMessage();
	}
}