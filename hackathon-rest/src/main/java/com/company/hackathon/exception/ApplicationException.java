package com.company.hackathon.exception;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = -7685284987611236365L;

	public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
