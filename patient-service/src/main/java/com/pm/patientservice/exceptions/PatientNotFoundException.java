package com.pm.patientservice.exceptions;

public class PatientNotFoundException extends RuntimeException{

    public PatientNotFoundException(String Message){
        super(Message);
    }
}
