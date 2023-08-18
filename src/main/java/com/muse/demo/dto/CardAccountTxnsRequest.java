package com.muse.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CardAccountTxnsRequest extends CommonRequest {


    private String request_id;

    private String order_no;

    @NotBlank
    private String user_id;

    @NotBlank
    private String card_id;


    private Long date_range_from;


    private Long date_range_to;

    @Max(1000)
    @Positive
    private Integer page_size;

    private Integer page_number;



}
