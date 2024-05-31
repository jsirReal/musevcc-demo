package com.muse.demo.dto;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @Date 2020/5/8 15:10
 **/

@Data
@ToString
public class QueryPartnerAddressRequest extends CommonRequest {

    @NotBlank
    private String currency;

    @Length(max=2048)
    private String description;

}
