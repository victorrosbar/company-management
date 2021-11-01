package br.com.vtech.management.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -9007395271286096383L;

	public NotFoundException() {
	}

	public NotFoundException(String message) {
		super(message);
	}
}
