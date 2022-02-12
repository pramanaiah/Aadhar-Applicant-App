package com.ramana.aadhar.applicant.response;

import com.ramana.aadhar.applicant.model.Applicant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class ApplicantResponse {
    private Date timestamp;
    private String message;
    private Applicant applicant;
}
