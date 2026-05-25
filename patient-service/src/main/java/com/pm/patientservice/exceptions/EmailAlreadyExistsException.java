package com.pm.patientservice.exceptions;

public class EmailAlreadyExistsException extends Exception {
    public EmailAlreadyExistsException(String messageFromException) {
        super(messageFromException);
    }
}
