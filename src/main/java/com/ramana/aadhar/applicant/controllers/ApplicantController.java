package com.ramana.aadhar.applicant.controllers;

import com.ramana.aadhar.applicant.exceptions.InvalidRequest;
import com.ramana.aadhar.applicant.model.Applicant;
import com.ramana.aadhar.applicant.model.ErrorMessage;
import com.ramana.aadhar.applicant.response.ApplicantResponse;
import com.ramana.aadhar.applicant.services.ApplicantService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(name = "/v1")
public class ApplicantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicantController.class);

    private ApplicantService applicantService;

    public ApplicantController(@Qualifier("applicantService") ApplicantService applicantService){
        this.applicantService = applicantService;
    }

    @PostMapping(path = "/applicant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Application submitted successfully", response = ApplicantResponse.class),
            @ApiResponse(code = 200, message = "OK",response = String.class),
            @ApiResponse(code = 404, message = "Applicant Not Found", response = ErrorMessage.class),
            @ApiResponse(code = 400, message = "Invalid Request", response = ErrorMessage.class),
            @ApiResponse(code = 403, message = "Unauthorized", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Forbidden", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)
    })
    public ResponseEntity<ApplicantResponse> saveApplicant(@Valid @RequestBody Applicant applicant){
        LOGGER.info("Inside Applicant Controller {} saveApplicant method{} Request:: " + applicant);
        if(applicant == null)
            throw new InvalidRequest("Invalid Request");
        ApplicantResponse response = this.applicantService.saveApplicant(applicant);
        LOGGER.info("Applicant Response:: " + response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
