package com.stackroute.restsample.validator;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CountryValidator implements ConstraintValidator<Country, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	
		
		List<String> countries=Arrays.asList("UK","Singapore","India","Japan");
		
		
		
		return countries.contains(value);
	}

}
