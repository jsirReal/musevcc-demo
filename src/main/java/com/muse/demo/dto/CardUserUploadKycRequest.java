package com.muse.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CardUserUploadKycRequest extends CommonRequest {

    // External identifier, unique under the partner. (Required)
    @NotBlank
    private String user_xid;

    // Individual cardholder identity information (Required)
    @NotNull
    private Individual individual;

    // Government Issued Identification Document Information
    private Document document;

    // Delivery address
    private Address address;

}
