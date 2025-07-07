package com.muse.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class QuotaCreateRequest extends CommonRequest{

    @NotBlank
    private  String request_id;

    //卡产品ID
    @NotBlank
    private String card_product_id;

    //卡等级
    @NotBlank
    private String card_level;

    //共享额度名称
    @NotBlank
    private String share_quota_name;

    //备注
    private String remark;
}
