package com.ramana.aadhar.applicant.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "applicant")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Applicant implements Serializable {
    @Id
    @GenericGenerator(name = "enrollment_id", strategy = "com.ramana.aadhar.applicant.util.EnrollmentIdGenerator")
    @GeneratedValue(generator = "enrollment_id")
    @Column(name = "enrollment_id", nullable = false)
    @ApiModelProperty(hidden = true)
    private String enrollmentId;
    @Column(name = "first_name", nullable = false)
    @NotNull(message = "First Name can't be empty or null")
    private String firstName;
    @NotNull(message = "FLast Name can't be empty or null")
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @NotNull(message = "Date of Birth can't be empty or null")
    @Column(name = "date_of_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfBirth;
    @NotNull(message = "Gender can't be empty or null")
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;
    @NotNull(message = "Email can't be empty or null")
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @NotNull(message = "Phone Number can't be empty or null")
    @Max(value = 10)
    @Min(10)
    @Column(name = "phone_number", nullable = false)
    private long phoneNumber;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "careOf", column = @Column(name = "address_care_of")),
            @AttributeOverride(name = "addressLine1", column = @Column(name = "address_address_line_1")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "address_address_line_2")),
            @AttributeOverride(name = "landmark", column = @Column(name = "address_landmark")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "postOffice", column = @Column(name = "address_post_office")),
            @AttributeOverride(name = "pinCode", column = @Column(name = "address_pin_code")),
            @AttributeOverride(name = "district", column = @Column(name = "address_district"))
    })
    private Address address;
}
