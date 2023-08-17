package com.muse.demo.utils;

import org.springframework.util.Base64Utils;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class RSAUtils {


    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    /**
     * RSA--PEM
     *
     * @param content      content to sign
     * @param privateKey
     * @param inputCharset
     * @return sign str
     */
    public static String sign(String content, String privateKey, String inputCharset) {

        if(content == null || "".equals(content)){
            throw new RuntimeException("sign content is null !");
        }

        if(privateKey == null || "".equals(privateKey)){
            throw new RuntimeException("sign privateKey is null !");
        }

        if(inputCharset == null || "".equals(inputCharset)){
            throw new RuntimeException("sign inputCharset is null !");
        }

        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64Utils.decodeFromString(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update(content.getBytes(inputCharset));
            byte[] signed = signature.sign();
            return Base64Utils.encodeToString(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * RSA verify--PEM
     *
     * @param content content to sign
     * @param sign    sign to compare
     * @return boolean
     */
    public static boolean verify(String content, String sign, String publicKey, String inputCharset) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64Utils.decodeFromString(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initVerify(pubKey);
            signature.update(content.getBytes(inputCharset));
            return signature.verify(Base64Utils.decodeFromString(sign));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



}
