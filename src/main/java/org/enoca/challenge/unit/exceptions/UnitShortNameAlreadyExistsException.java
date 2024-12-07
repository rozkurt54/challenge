package org.enoca.challenge.unit.exceptions;

public class UnitShortNameAlreadyExistsException extends RuntimeException{

    public UnitShortNameAlreadyExistsException() {
        super("Given short name already exists.");
    }

    public UnitShortNameAlreadyExistsException(String message) {
        super(message);
    }
}
