package com.sns.untitled.exception;

public class DuplicatedException extends RuntimeException{
	public DuplicatedException(String cause){
		super(cause);
	}
}
