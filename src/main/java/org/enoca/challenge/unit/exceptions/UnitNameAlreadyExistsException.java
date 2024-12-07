package org.enoca.challenge.unit.exceptions;

public class UnitNameAlreadyExistsException extends RuntimeException {

    public UnitNameAlreadyExistsException() {
        super("Given value already exists");
    }

    public UnitNameAlreadyExistsException(String message) {
        super(message);
    }
}
