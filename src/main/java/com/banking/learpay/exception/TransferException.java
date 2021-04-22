package com.banking.learpay.exception;


public class TransferException extends Exception  {

	private static final long serialVersionUID = 1L;

	public TransferException() {
		super();
	}

	public TransferException(String message) {
		super(message);
	}

	public TransferException(String message, Throwable cause) {
		super(message, cause);
	}

}
