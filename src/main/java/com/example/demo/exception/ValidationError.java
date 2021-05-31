package com.example.demo.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	
	private List<FieldMessage> errors = new ArrayList<FieldMessage>();
	
	public ValidationError() {
		super();
	}

	public ValidationError(Long timestamp, Integer status, String msg) {
		super(timestamp, status, msg);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

}
