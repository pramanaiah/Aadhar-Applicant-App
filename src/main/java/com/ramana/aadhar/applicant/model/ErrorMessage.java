package com.ramana.aadhar.applicant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ErrorMessage {
    private int statusCode;
    private String path;
    private Date timestamp;
    private String message;
    private String description;
}
