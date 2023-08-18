package com.muse.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Individual {
    // Last name / Surname of cardholder (Required)
    @NotBlank
    private String last_name;

    // First name of cardholder (Required)
    @NotBlank
    private String first_name;

    // Date of birth (YYYY-MM-DD) (Required)
    @NotBlank
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String date_of_birth;

    // Occupation of cardholder
    private String occupation;

    // Annual income of cardholder in card currency
    private String annual_income;
}
