package com.muse.demo;


import com.alibaba.fastjson.JSON;
import com.muse.demo.dto.*;
import com.muse.demo.utils.OkHttpUtils;
import com.muse.demo.utils.SignUtils;
import okhttp3.OkHttpClient;

public class MuseClient {

    private String merchantPrivateKey;

    private String platformPublicKey;

    private String baseUrl;

    private OkHttpClient httpClient;

    private void MuseClient() {

    }

    public static MuseClient build(String baseUrl, String merchantPrivateKey, String platformPublicKey) {
        MuseClient client = new MuseClient();
        client.baseUrl = baseUrl;
        client.merchantPrivateKey = merchantPrivateKey;
        client.platformPublicKey = platformPublicKey;
        client.httpClient = new OkHttpClient();
        return client;
    }

    /**
     * cardApply
     */
    public String cardApply(String request_id, String card_level, String card_product_id,
                                      String partner_id, String user_id) {
        CardApplyRequest request = new CardApplyRequest();
        request.setRequest_id(request_id);
        request.setCard_level(card_level);
        request.setCard_product_id(card_product_id);
        request.setPhone_area_code("86");
        request.setPhone_number("13312345678");
        request.setUser_id(user_id);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/apply",
                JSON.toJSONString(request));
    }

    /**
     * cardApplyResult
     */
    public String cardApplyResult(String request_id, String apply_id,
                            String partner_id, String user_id) {
        CardApplyResultRequest request = new CardApplyResultRequest();
        request.setRequest_id(request_id);
        request.setApply_id(apply_id);
        request.setUser_id(user_id);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/apply-result",
                JSON.toJSONString(request));
    }

    /**
     * cardQuery
     */
    public String cardQuery(String card_id, String partner_id, String user_id) {
        CardQueryRequest request = new CardQueryRequest();
        request.setCard_id(card_id);
        request.setUser_id(user_id);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/query",
                JSON.toJSONString(request));
    }

    /**
     * cardActivate
     */
    public String cardActivate(String card_id, String partner_id, String user_id) {
        CardOperationRequest request = new CardOperationRequest();
        request.setCard_id(card_id);
        request.setUser_id(user_id);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/activate",
                JSON.toJSONString(request));
    }

    /**
     * cardLock
     */
    public String cardLock(String card_id, String partner_id, String user_id) {
        CardOperationRequest request = new CardOperationRequest();
        request.setCard_id(card_id);
        request.setUser_id(user_id);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/lock",
                JSON.toJSONString(request));
    }

    /**
     * cardUnLock
     */
    public String cardUnlock(String card_id, String partner_id, String user_id) {
        CardOperationRequest request = new CardOperationRequest();
        request.setCard_id(card_id);
        request.setUser_id(user_id);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/unlock",
                JSON.toJSONString(request));
    }

    /**
     * cardSensitiveInfoUrl
     */
    public String cardSensitiveInfoUrl(String card_id, String ip_address,String partner_id, String user_id) {
        CardSensitiveInfoRequest request = new CardSensitiveInfoRequest();
        request.setCard_id(card_id);
        request.setUser_id(user_id);
        request.setIp_address(ip_address);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/card-sensitive-info",
                JSON.toJSONString(request));
    }

    /**
     * cardChangePin
     */
    public String cardChangePin(String card_id, String pin,String partner_id, String user_id) {
        CardChangePinRequest request = new CardChangePinRequest();
        request.setCard_id(card_id);
        request.setUser_id(user_id);
        request.setCard_pin(pin);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/change-pin",
                JSON.toJSONString(request));
    }

}
