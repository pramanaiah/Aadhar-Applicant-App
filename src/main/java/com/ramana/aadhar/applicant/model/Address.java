package com.ramana.aadhar.applicant.model;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private String careOf;
    private String addressLine1;
    private String addressLine2;
    private String landmark;
    private String city;
    private String postOffice;
    private Integer pinCode;
    private String district;
}
