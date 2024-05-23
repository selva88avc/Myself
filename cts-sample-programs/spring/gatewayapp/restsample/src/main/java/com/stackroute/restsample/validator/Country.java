package com.stackroute.restsample.validator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ FIELD})
@Retention(RUNTIME)

@Constraint(validatedBy = CountryValidator.class)
@Documented
public @interface Country {

	String message() default "country is invalid";
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
