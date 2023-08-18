package com.muse.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CardUserQueryRequest extends CommonRequest {

    // User ID
    private String user_id;

    @NotBlank
    // User external ID (Required)
    private String user_xid;

    // Email address
    private String email;

    // Phone number
    private String phone_number;

}
