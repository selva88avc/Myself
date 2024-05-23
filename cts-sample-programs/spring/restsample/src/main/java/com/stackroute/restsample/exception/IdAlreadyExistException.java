package com.stackroute.restsample.exception;

public class IdAlreadyExistException extends  RuntimeException{

	public IdAlreadyExistException(String s)
	{
		super(s);
	}
}
