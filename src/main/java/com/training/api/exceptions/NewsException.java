package com.training.api.exceptions;



public class NewsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NewsException(String msg) {
		super(msg);
	}

}
