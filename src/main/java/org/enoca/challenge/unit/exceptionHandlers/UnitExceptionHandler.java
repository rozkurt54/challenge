package org.enoca.challenge.unit.exceptionHandlers;

import org.enoca.challenge.core.tools.StandardizedResponseUtil;
import org.enoca.challenge.unit.exceptions.UnitNameAlreadyExistsException;
import org.enoca.challenge.unit.exceptions.UnitShortNameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UnitExceptionHandler {

    @ExceptionHandler(value = {UnitNameAlreadyExistsException.class})
    protected ResponseEntity<?> unitNameAlreadyExistsExceptionHandler(UnitNameAlreadyExistsException unitNameAlreadyExistsException) {

        var responseCode = HttpStatus.BAD_REQUEST;

        var response = StandardizedResponseUtil.createErrorResponse(responseCode, unitNameAlreadyExistsException.getMessage());

        return new ResponseEntity<>(responseCode, responseCode);

    }

    @ExceptionHandler(value = {UnitShortNameAlreadyExistsException.class})
    protected ResponseEntity<?> unitShortNameAlreadyExistsExceptionHandler(UnitShortNameAlreadyExistsException unitShortNameAlreadyExistsException) {

        var responseCode = HttpStatus.BAD_REQUEST;

        var response = StandardizedResponseUtil.createErrorResponse(responseCode, unitShortNameAlreadyExistsException.getMessage());

        return new ResponseEntity<>(response, responseCode);

    }

}
