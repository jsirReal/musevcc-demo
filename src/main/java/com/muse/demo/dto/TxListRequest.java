package com.muse.demo.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class TxListRequest extends CommonRequest{

    @NotBlank
    private String share_quota_id;

    @NotBlank
    private String request_id;

    @NotBlank
    private String start_time;

    @NotBlank
    private String end_time;

    @NotBlank
    private String limit;

    @NotBlank
    private String page;

}
