package canair.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler that catches any exceptions thrown by other controllers.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	//Example
	//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	//@ExceptionHandler(IllegalArgumentException.class)
	//public String invalidBean(Exception e) {...}
	
	//Return Date Missing is the most likely cause of the error, but this catches all errors just in case.
	//Mainly used for testing.
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public String returnDateMissing(Exception e) {
		e.printStackTrace();
		return "Error caught by global exception handler.";
	}
}
