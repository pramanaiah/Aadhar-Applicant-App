package com.ramana.aadhar.applicant.repositories;

import com.ramana.aadhar.applicant.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, String> {
}
