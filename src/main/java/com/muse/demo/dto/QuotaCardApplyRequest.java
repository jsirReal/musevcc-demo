package com.muse.demo.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class QuotaCardApplyRequest extends CommonRequest{

    @NotBlank
    private String share_quota_id;

    @NotBlank
    private String user_id;

    @NotBlank
    private String request_id;

    @NotBlank
    private String card_product_id;

    @NotBlank
    private String card_level;

    @NotBlank
    private String phone_number;

    @NotBlank
    private String phone_area_code;

    private String embossed_name;

}
