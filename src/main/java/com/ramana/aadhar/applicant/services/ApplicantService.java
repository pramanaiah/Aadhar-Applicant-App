package com.ramana.aadhar.applicant.services;

import com.ramana.aadhar.applicant.model.Applicant;
import com.ramana.aadhar.applicant.response.ApplicantResponse;

public interface ApplicantService {
    ApplicantResponse saveApplicant(Applicant applicant);
}
