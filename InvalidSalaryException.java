package com.Aditya.Employee;

public class InvalidSalaryException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidSalaryException(String message) {
		super(message);
	}
}