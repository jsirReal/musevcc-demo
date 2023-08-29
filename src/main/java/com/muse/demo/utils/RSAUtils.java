package com.muse.demo.utils;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.stream.Collectors;


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

    @SneakyThrows
    public static RSAPrivateKey getRSAPrivateKey(String privateKey) {
        privateKey = trim(privateKey);
        KeyFactory kFactory = KeyFactory.getInstance("RSA");
        // decode base64 of your key
        byte[] yourKey =  Base64Utils.decodeFromString(privateKey);
        // generate the public key
        PKCS8EncodedKeySpec spec =  new PKCS8EncodedKeySpec(yourKey);
        return (RSAPrivateKey) kFactory.generatePrivate(spec);
    }

    @SneakyThrows
    public static RSAPublicKey getRSAPublicKey(String publicKey) {
        publicKey = trim(publicKey);

        KeyFactory kFactory = KeyFactory.getInstance("RSA");
        // decode base64 of your key
        byte[] yourKey =  Base64Utils.decodeFromString(publicKey);
        // generate the public key
        X509EncodedKeySpec spec =  new X509EncodedKeySpec(yourKey);
        return (RSAPublicKey) kFactory.generatePublic(spec);
    }

    public static String trim(String key) {
        return Arrays.stream(key.split("\n"))
                .filter(StringUtils::isNotBlank)
                .map(s -> s.replaceAll("\\s+", ""))
                .filter(i -> !i.startsWith("-----"))
                .collect(Collectors.joining());
    }

    public static String encrypt(String text, String publicStr) throws Exception {
        PublicKey publicKey = getRSAPublicKey(publicStr);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(text.getBytes());
        return Base64Utils.encodeToString(bytes);
    }

    public static String decrypt(String text, String privateStr) throws Exception {
        PrivateKey privateKey = getRSAPrivateKey(privateStr);
        KeyFactory keyFactory1 = KeyFactory.getInstance("RSA");
        Cipher cipher = Cipher.getInstance(keyFactory1.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytes = cipher.doFinal(Base64Utils.decode(text.getBytes()));
        return new String(bytes, StandardCharsets.UTF_8);
    }


}
