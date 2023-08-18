package com.muse.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Document {
    // passport or national_id (Required)
    @NotBlank
    private String type;

    // The front of a document file encoded in data URI base64 encoded format (Required)
    @NotBlank
    private String front;

    // The back of a document file encoded in data URI base64 encoded format
    private String back;

    // Identification document number (Required)
    @NotBlank
    private String number;

    // Issuing country of identification document in ISO3166-1 alpha-2 format (Required)
    @NotBlank
    private String country;

    // Expiry date of identification document (YYYY-MM-DD) (Required)
    @NotBlank
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String expiry_date;
}
