package com.bank.sean.grano.exception;

public class CustomException extends RuntimeException {
	public CustomException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
