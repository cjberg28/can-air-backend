package canair.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	//Example
	//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	//@ExceptionHandler(IllegalArgumentException.class)
	//public String invalidBean(Exception e) {...}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public String returnDateMissing(Exception e) {
		return "Error: Round-trip flight selected but no return date provided.";
	}
}
