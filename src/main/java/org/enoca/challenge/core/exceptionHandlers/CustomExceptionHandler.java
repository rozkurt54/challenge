package org.enoca.challenge.core.exceptionHandlers;


import jakarta.servlet.http.HttpServletRequest;
import org.enoca.challenge.core.exceptions.EntityNotFoundException;
import org.enoca.challenge.core.tools.StandardizedResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException, HttpServletRequest request) {

        var responseCode = HttpStatus.BAD_REQUEST;

        var response = StandardizedResponseUtil.createErrorResponse(responseCode, entityNotFoundException.getMessage());

        return new ResponseEntity<>(response, responseCode);

    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {

        var responseCode = HttpStatus.BAD_REQUEST;

        var messages = new HashMap<String, String>();

        methodArgumentNotValidException.getFieldErrors()
                .forEach(fieldError -> messages.put(fieldError.getField(), fieldError.getDefaultMessage()));

        var response = StandardizedResponseUtil.createErrorResponse(responseCode, messages);

        return new ResponseEntity<>(response, responseCode);
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    protected ResponseEntity<?> handleHttpMethodNotSupportedException(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException) {

        var responseCode = HttpStatus.METHOD_NOT_ALLOWED;

        var message = httpRequestMethodNotSupportedException.getMessage();

        var response = StandardizedResponseUtil.createErrorResponse(responseCode, message);

        return new ResponseEntity<>(response, responseCode);

    }
}
