package com.ramana.aadhar.applicant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApplicantNotFound extends RuntimeException{

    public ApplicantNotFound(String message){
        super(message);
    }
}
