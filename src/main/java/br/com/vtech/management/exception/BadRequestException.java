package br.com.vtech.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -240115306138766574L;

	public static enum MESSAGES {
		
		CNPJ_ALREADY_EXISTS("Company is already registered."),
		COMPANY_NOT_FOUND("Company not found");
		
		private String msg;

		MESSAGES(String string) {
			this.msg = string;
		}

		public String msg() {
			return msg;
		}
	}

		public BadRequestException() {
	}

	public BadRequestException(MESSAGES message) {
		super(message.msg());
	}
}
