package rs.ac.bg.fon.ai.milansusa.bookstore.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import rs.ac.bg.fon.ai.milansusa.bookstore.services.UserServiceException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { UserServiceException.class })
	protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
		String bodyOfResponse = Response.BAD_REQUEST.getBody();
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

}
