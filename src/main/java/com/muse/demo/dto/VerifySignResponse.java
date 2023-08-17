package com.muse.demo.dto;

import java.io.Serializable;


public class VerifySignResponse implements Serializable {

    private static final long serialVersionUID = 8284808440960086184L;

    /**
     * if the signature verification is passed, true will pass and false will not
     */
    private Boolean signOk;


    /**
     * private key type
     */
    private String keyType;


    public Boolean getSignOk() {
        return signOk;
    }

    public void setSignOk(Boolean signOk) {
        this.signOk = signOk;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }


    @Override
    public String toString() {
        return "VerifySignResponse{" +
                "signOk=" + signOk +
                ", keyType='" + keyType + '\'' +
                '}';
    }
}
