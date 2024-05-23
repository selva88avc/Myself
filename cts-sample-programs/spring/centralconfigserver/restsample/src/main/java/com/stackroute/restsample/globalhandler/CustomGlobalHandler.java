package com.stackroute.restsample.globalhandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.stackroute.restsample.exception.IdAlreadyExistException;
import com.stackroute.restsample.exception.IdNotFoundException;

import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class CustomGlobalHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)

	protected ResponseEntity<Object> handleInvalidData(MethodArgumentNotValidException ex,WebRequest req)
	{
		Map<String ,Object> resbody= new LinkedHashMap();
		
		resbody.put("timestamp", new Date());
		
		List<String> errors=ex.getBindingResult().getFieldErrors().stream()
				.map( ferror->ferror.getDefaultMessage()).collect(Collectors.toList());
		
		resbody.put("Errors " , errors);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resbody);
				
		
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	
	public ResponseEntity<String> handleIdnotFound(HttpServletResponse res)
	{
		String resobj=res.toString();
		return new ResponseEntity<String>("Given Id does not Exist in DB " ,HttpStatus.NOT_FOUND);
				
	}
	
	@ExceptionHandler(IdAlreadyExistException.class)
	public ResponseEntity<?> handlerduplicateId(WebRequest res,IdAlreadyExistException excep)
	{
		String resobj=res.toString();
Map<String ,Object> resbody= new LinkedHashMap();
		
		resbody.put("timestamp", new Date());
		resbody.put("response object is " , resobj);
		resbody.put("error msg ", excep.getMessage());
		
		//return new ResponseEntity<Map>(resbody,HttpStatus.CONFLICT);
		
		
		return new ResponseEntity<String>("Duplicate ID" ,HttpStatus.CONFLICT);
		
		
	}
	
	
}
// HttpServletRequest,HttpServletResponse,HttpSession,HttpCookies,WebRequest
