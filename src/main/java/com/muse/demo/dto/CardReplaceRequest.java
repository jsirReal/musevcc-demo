package com.muse.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CardReplaceRequest extends CommonRequest {


    /**
     * 用户UserId,所属MUSE平台
     */
    @NotBlank
    private String user_id;
    /**
     * 原始卡ID
     */
    @NotBlank
    private String original_card_id;

    /**
     * 替换原因
     */
    @NotBlank
    private String replace_reason;

    /**
     * request_id
     */
    @NotBlank
    private String request_id;

}
