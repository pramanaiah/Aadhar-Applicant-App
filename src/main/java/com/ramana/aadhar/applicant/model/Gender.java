package com.ramana.aadhar.applicant.model;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE"),
    TRANS_GENDER("TRANS_GENDER");

    private final String gender;

    Gender(String gender){
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
