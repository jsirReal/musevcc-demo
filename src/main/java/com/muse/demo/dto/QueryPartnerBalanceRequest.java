package com.muse.demo.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @Date 2020/5/8 15:10
 **/

@Data
@ToString
public class QueryPartnerBalanceRequest extends CommonRequest {

    @NotBlank
    private String currency;

}
