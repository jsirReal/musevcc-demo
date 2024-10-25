package com.muse.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class LimitChangeRequest extends CommonRequest {

    /**
     * 商户号
     */
    @NotBlank
    private String partner_id;
    /**
     * 用户UID
     */
    @NotBlank
    private String user_id;
    /**
     * 卡ID
     */
    @NotBlank
    private String card_id;
    /**
     * 日交易限额
     */
    @NotBlank
    private BigDecimal daily_purchase_limit;

}
