package com.muse.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CardUserCreateRequest extends CardUserUploadKycRequest {

    // Nickname of user account, a human-friendly non-unique name for a user account
    private String user_name;

    // Email address of cardholder (Required)
    @NotBlank
    private String email;



}
