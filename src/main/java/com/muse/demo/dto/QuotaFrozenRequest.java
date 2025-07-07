package com.muse.demo.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class QuotaFrozenRequest extends CommonRequest {

    // 共享额度ID
    @NotBlank
    private String share_quota_id;

    @NotBlank
    private String request_id;
}
