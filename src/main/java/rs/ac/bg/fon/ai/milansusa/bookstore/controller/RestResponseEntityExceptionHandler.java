package rs.ac.bg.fon.ai.milansusa.bookstore.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.gson.JsonObject;

import rs.ac.bg.fon.ai.milansusa.bookstore.service.UserServiceException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { UserServiceException.class })
	protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
		JsonObject response = new JsonObject();
		response.addProperty("code", String.valueOf(Response.CONFLICT.getCode()));
		response.addProperty("message", String.valueOf(Response.CONFLICT.getBody()));
		return handleExceptionInternal(ex, response.toString(), new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

}
