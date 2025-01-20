package com.muse.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CardUserKycLinkRequest extends CommonRequest {

    // External identifier, unique under the partner. (Required)
    @NotBlank
    private String user_xid;

}
