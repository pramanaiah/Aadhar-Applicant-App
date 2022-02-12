package com.ramana.aadhar.applicant.exceptions;

import com.ramana.aadhar.applicant.model.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(InvalidRequest.class)
    public ResponseEntity<ErrorMessage> invalidRequestException(Exception e, WebRequest request){
        LOGGER.info("Inside ControllerExceptionHandler {} invalidRequestException method {}");
        ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), request.getContextPath(), new Date(), e.getMessage(), request.getDescription(false));
        LOGGER.error("Invalid Request Exception:: " + error);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> methodArgumentNotValidException(Exception e, WebRequest request){
        LOGGER.info("Inside ControllerExceptionHandler {} methodArgumentNotValidException method {}");
        ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), request.getContextPath(), new Date(), e.getMessage(), request.getDescription(false));
        LOGGER.error("Invalid Request Exception:: " + error);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApplicantNotFound.class)
    public ResponseEntity<ErrorMessage> applicantNotFoundException(Exception e, WebRequest request){
        LOGGER.info("Inside ControllerExceptionHandler {} applicantNotFoundException method {}");
        ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(), request.getContextPath(), new Date(), e.getMessage(), request.getDescription(false));
        LOGGER.error("Applicant Not Found Exception:: " + error);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> internalServerError(Exception e, WebRequest request){
        LOGGER.info("Inside ControllerExceptionHandler {} internalServerError method {}");
        ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getContextPath(), new Date(), e.getMessage(), request.getDescription(false));
        LOGGER.error("Internal Server Error:: " + error);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
