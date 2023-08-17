package com.muse.demo.dto;

import java.io.Serializable;


public class VerifySignRequest implements Serializable {

    private static final long serialVersionUID = 1972494222839397203L;

    /**
     * content to be signed and verified
     */
    private String content;

    /**
     * character set encoding
     */
    private String charset;


    private String sign;


    private String publicKey;

    /**
     * private key type
     */
    private String keyType;


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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }


    @Override
    public String toString() {
        return "VerifySignRequest{" +
                "content='" + content + '\'' +
                ", charset='" + charset + '\'' +
                ", sign='" + sign + '\'' +
                ", publicKey='" + publicKey + '\'' +
                ", keyType='" + keyType + '\'' +
                '}';
    }
}
