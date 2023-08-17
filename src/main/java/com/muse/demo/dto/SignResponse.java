package com.muse.demo.dto;

import java.io.Serializable;


public class SignResponse implements Serializable {

    private static final long serialVersionUID = -8193673986373552591L;


    /**
     * signature
     */
    private String sign;

    /**
     * private key type
     */
    private String keyType;


    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }


    @Override
    public String toString() {
        return "SignResponse{" +
                "sign='" + sign + '\'' +
                ", keyType='" + keyType + '\'' +
                '}';
    }
}
