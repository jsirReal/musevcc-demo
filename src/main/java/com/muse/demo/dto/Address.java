package com.muse.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Address {
    // Delivery country of identification document in ISO3166-1 alpha-2 format (Required)
    @NotBlank
    private String country;

    // Delivery city
    private String city;

    // Delivery post code
    private String post_code;

    // Detail delivery address
    private String details;
}
