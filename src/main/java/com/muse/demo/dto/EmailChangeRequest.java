package com.muse.demo.dto;


import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class EmailChangeRequest extends CommonRequest{

    @NotBlank
    private String email;

    @NotBlank
    private String user_id;

}
