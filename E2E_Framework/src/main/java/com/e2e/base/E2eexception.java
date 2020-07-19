package com.e2e.base;

/**
 * @author Shridhara
 *
 */
public class E2eexception extends Throwable {

	/**
	 * @param message
	 * @param cause
	 */
	public E2eexception(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 5681570880721278479L;

	/**
	 * @param message
	 */
	public E2eexception(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
