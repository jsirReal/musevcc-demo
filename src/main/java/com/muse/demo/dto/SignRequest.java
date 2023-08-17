package com.muse.demo.dto;

import java.io.Serializable;


public class SignRequest implements Serializable {

    private static final long serialVersionUID = 6977001223126224941L;


    /**
     * content to be signed and verified
     */
    private String content;

    /**
     * character set encoding
     */
    private String charset;

    /**
     * private key type
     */
    private String keyType;

    /**
     * private key
     */
    private String privateKey;



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }


    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }


    @Override
    public String toString() {
        return "SignRequest{" +
                "content='" + content + '\'' +
                ", charset='" + charset + '\'' +
                ", keyType='" + keyType + '\'' +
                ", privateKey='" + privateKey + '\'' +
                '}';
    }
}
