package com.ramana.aadhar.applicant.dao;

import com.ramana.aadhar.applicant.model.Applicant;
import com.ramana.aadhar.applicant.repositories.ApplicantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicantDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicantDao.class);

    private ApplicantRepository repository;

    @Autowired
    public ApplicantDao(ApplicantRepository repository){
        this.repository = repository;
    }

    public Applicant saveApplicant(Applicant applicant){
        LOGGER.info("Inside ApplicantDao class {} saveApplicant() method{}");
        Applicant savedApplicant = this.repository.save(applicant);
        LOGGER.info("Applicant saved successfully.");
        return savedApplicant;
    }
}
