package com.stackroute.streams;

public class CountryNotFoundException extends RuntimeException{
	public CountryNotFoundException(String errorMsg) {
		super(errorMsg);
	}

}
