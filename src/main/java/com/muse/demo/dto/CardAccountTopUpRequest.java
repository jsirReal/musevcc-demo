package com.muse.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CardAccountTopUpRequest extends CommonRequest {

    @NotBlank
    private String request_id;

    @NotBlank
    private String user_id;

    @NotBlank
    private String card_id;

    @NotBlank
    private String amount;

    @NotBlank
    private String currency;



}
