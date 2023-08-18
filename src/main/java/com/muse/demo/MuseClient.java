package com.muse.demo;


import com.alibaba.fastjson.JSON;
import com.muse.demo.dto.CardApplyRequest;
import com.muse.demo.dto.CardApplyResultRequest;
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


}
