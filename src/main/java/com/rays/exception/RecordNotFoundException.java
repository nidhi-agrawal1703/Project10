package com.rays.exception;

public class RecordNotFoundException extends RuntimeException {

	public RecordNotFoundException(String msg) {
		super(msg);
	}
	public RecordNotFoundException(String msg,Throwable cause) {
		super(msg,cause);
	}
}
