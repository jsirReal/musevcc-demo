package com.muse.demo.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Description open api 公用 属性
 **/

@Data
@ToString
public class CommonRequest implements Serializable {

    // 商户号
    @NotBlank
    private String partner_id;

    // 签名类型
    @NotBlank
    private String sign_type;

    // 签名
    @NotBlank
    private String sign;

    // 时间戳
    @NotBlank
    private String timestamp;

    @NotBlank
    private String nonce;

}
