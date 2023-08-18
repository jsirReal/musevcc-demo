package com.muse.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CardApplyResultRequest extends CommonRequest {

    @NotBlank
    private String request_id;

    private String apply_id;

    @NotBlank
    private String user_id;

}
