package com.muse.demo.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class QuotaListRequest extends CommonRequest{

    //共享额度ID
    @NotBlank
    private String share_quota_id;

    //每页记录数
    @NotBlank
    private String limit;

    //页码
    @NotBlank
    private String page;


}
