package com.muse.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class TxAdjustmentRequest extends CommonRequest{

    @NotBlank
    private String share_quota_id;

    @NotBlank
    private String amount;

    @NotBlank
    private String request_id;

    @NotBlank
    private String remark;
}
