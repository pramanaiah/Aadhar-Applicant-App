package com.ramana.aadhar.applicant.services;

import com.ramana.aadhar.applicant.dao.ApplicantDao;
import com.ramana.aadhar.applicant.model.Applicant;
import com.ramana.aadhar.applicant.response.ApplicantResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Qualifier("applicantService")
public class ApplicantServiceImpl implements ApplicantService{

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicantServiceImpl.class);

    private ApplicantDao applicantDao;

    @Autowired
    public ApplicantServiceImpl(ApplicantDao applicantDao){
        this.applicantDao = applicantDao;
    }

    @Override
    public ApplicantResponse saveApplicant(Applicant applicant) {
        LOGGER.info("Inside Applicant Service {} saveApplicant method{}");
        Applicant savedApplicant = this.applicantDao.saveApplicant(applicant);
        ApplicantResponse response = new ApplicantResponse();
        response.setTimestamp(new Date());
        response.setMessage("Applicant Application submitted successfully.");
        response.setApplicant(savedApplicant);
        return response;
    }
}
