package com.employee.exception;

public class InvalidEmployeeDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEmployeeDataException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidEmployeeDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidEmployeeDataException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidEmployeeDataException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidEmployeeDataException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
