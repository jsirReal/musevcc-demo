package com.muse.demo;

import com.alibaba.fastjson.JSON;
import com.muse.demo.dto.*;
import com.muse.demo.utils.OkHttpSSL;
import com.muse.demo.utils.OkHttpUtils;
import com.muse.demo.utils.RSAUtils;
import com.muse.demo.utils.SignUtils;
import lombok.SneakyThrows;
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

    @SneakyThrows
    public static MuseClient buildNoSSL(String baseUrl, String merchantPrivateKey, String platformPublicKey) {
        MuseClient client = new MuseClient();
        client.baseUrl = baseUrl;
        client.merchantPrivateKey = merchantPrivateKey;
        client.platformPublicKey = platformPublicKey;
        client.httpClient = new OkHttpClient.Builder()
                .sslSocketFactory(OkHttpSSL.getIgnoreInitedSslContext().getSocketFactory(),OkHttpSSL.IGNORE_SSL_TRUST_MANAGER_X509)
                .hostnameVerifier(OkHttpSSL.getIgnoreSslHostnameVerifier())
                .build();
        return client;
    }

    /**
     * cardUserCreate
     */
    public String cardUserCreate(String user_name, String email,
                                 String partner_id, String xid,Individual individual,Document document) {
        CardUserCreateRequest request = new CardUserCreateRequest();
        request.setUser_name(user_name);
        request.setEmail(email);
        request.setUser_xid(xid);
        request.setIndividual(individual);
        request.setDocument(document);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "carduser/create",
                JSON.toJSONString(request));
    }

    /**
     * cardUserQuery
     */
    public String cardUserQuery(String user_id, String email,
                                String partner_id, String xid,String phone_number) {
        CardUserQueryRequest request = new CardUserQueryRequest();
        request.setUser_id(user_id);
        request.setEmail(email);
        request.setUser_xid(xid);
        request.setPhone_number(phone_number);


        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "carduser/query",
                JSON.toJSONString(request));
    }

    /**
     * cardUserUploadKyc
     */
    public String cardUserUploadKyc(String partner_id, String xid,Individual individual,Document document,Address address) {
        CardUserUploadKycRequest request = new CardUserUploadKycRequest();
        request.setUser_xid(xid);
        request.setIndividual(individual);
        request.setDocument(document);
        request.setAddress(new Address());
        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));
        request.setAddress(address);

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "carduser/upload-kyc",
                JSON.toJSONString(request));
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
     * cardActivate
     */
    public String updateCardPhone(String card_id, String partner_id, String user_id,String area_code, String phone_no) {
        CardPhoneUpdateRequest request = new CardPhoneUpdateRequest();
        request.setCard_id(card_id);
        request.setUser_id(user_id);
        request.setPhone_number(phone_no);
        request.setPhone_area_code(area_code);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/update-phone",
                JSON.toJSONString(request));
    }

    /**
     * cardActivate
     */
    public String physicalCardActivate(String card_id, String partner_id, String user_id) {
        CardOperationRequest request = new CardOperationRequest();
        request.setCard_id(card_id);
        request.setUser_id(user_id);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/activate-physical",
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
    @SneakyThrows
    public String cardChangePin(String card_id, String pin,String partner_id, String user_id) {
        CardChangePinRequest request = new CardChangePinRequest();
        request.setCard_id(card_id);
        request.setUser_id(user_id);
        request.setCard_pin(RSAUtils.encrypt(pin, platformPublicKey));

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/change-pin",
                JSON.toJSONString(request));
    }

    /**
     * cardAccountTopUp
     */
    public String cardAccountTopUp(String request_id,String card_id, String currency,String amount,String partner_id, String user_id) {
        CardAccountTopUpRequest request = new CardAccountTopUpRequest();
        request.setCard_id(card_id);
        request.setUser_id(user_id);
        request.setCurrency(currency);
        request.setAmount(amount);
        request.setRequest_id(request_id);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "cardaccount/topup",
                JSON.toJSONString(request));
    }


    /**
     * cardAccountTransactions
     */
    public String cardAccountTransactions(String request_id,String card_id,String order_no,String partner_id, String user_id,int pageNumber) {
        CardAccountTxnsRequest request = new CardAccountTxnsRequest();
        request.setCard_id(card_id);
        request.setUser_id(user_id);
        request.setRequest_id(request_id);
        request.setOrder_no(order_no);
        request.setPage_number(pageNumber);
        request.setDate_range_from(1592772500847L);


        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "cardaccount/transactions",
                JSON.toJSONString(request));
    }

    /**
     * 查询商户余额
     * @param currency
     * @param partner_id
     * @return
     */
    public String queryPartnerBalance(String currency, String partner_id) {
        QueryPartnerBalanceRequest request = new QueryPartnerBalanceRequest();
        request.setCurrency(currency);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "balance/partner",
                JSON.toJSONString(request));
    }

    /**
     * 查询商户地址
     * @param currency
     * @param partner_id
     * @return
     */
    public String queryPartnerAddress(String currency, String partner_id, String description) {
        QueryPartnerAddressRequest request = new QueryPartnerAddressRequest();
        request.setCurrency(currency);
        request.setDescription(description);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "balance/partner-address",
                JSON.toJSONString(request));
    }


}
