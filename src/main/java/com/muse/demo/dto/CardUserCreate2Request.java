package com.muse.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CardUserCreate2Request extends CommonRequest {

    // External identifier, unique under the partner. (Required)
    @NotBlank
    private String user_xid;

    // Email address of cardholder (Required)
    @NotBlank
    @Email
    private String email;

    // Nickname of user account, a human-friendly non-unique name for a user account
    private String user_name;

}
