package com.muse.demo;

import com.alibaba.fastjson.JSON;
import com.muse.demo.dto.*;
import com.muse.demo.utils.OkHttpSSL;
import com.muse.demo.utils.OkHttpUtils;
import com.muse.demo.utils.RSAUtils;
import com.muse.demo.utils.SignUtils;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;

import java.math.BigDecimal;

public class MuseClient {

    private String merchantPrivateKey;

    private String platformPublicKey;

    private String baseUrl;

    private String partnerId;

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

    public static MuseClient build(String baseUrl, String merchantPrivateKey, String platformPublicKey, String partnerId) {
        MuseClient client = new MuseClient();
        client.baseUrl = baseUrl;
        client.merchantPrivateKey = merchantPrivateKey;
        client.platformPublicKey = platformPublicKey;
        client.partnerId = partnerId;

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
                .sslSocketFactory(OkHttpSSL.getIgnoreInitedSslContext().getSocketFactory(), OkHttpSSL.IGNORE_SSL_TRUST_MANAGER_X509)
                .hostnameVerifier(OkHttpSSL.getIgnoreSslHostnameVerifier())
                .build();
        return client;
    }

    /**
     * cardUserCreate
     */
    public String cardUserCreate(String user_name, String email,
                                 String partner_id, String xid, Individual individual, Document document) {
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

    public String aipCardUserCreate(String user_name, String email,
                                    String xid, String partner_id) {
        AipCardUserCreateRequest request = new AipCardUserCreateRequest();
        request.setUser_name(user_name);
        request.setEmail(email);
        request.setUser_xid(xid);


        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "carduser/create",
                JSON.toJSONString(request));
    }

    public String cardUserCreateWithKYCLink(String user_name, String email,
                                            String partner_id, String xid) {
        CardUserCreateRequest request = new CardUserCreateRequest();
        request.setUser_name(user_name);
        request.setEmail(email);
        request.setUser_xid(xid);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "carduser/create-with-kyc-link",
                JSON.toJSONString(request));
    }


    /**
     * generate kyc application link for user
     */
    public String generateKycLink(String xid, String partner_id) {
        CardUserKycLinkRequest request = new CardUserKycLinkRequest();
        request.setUser_xid(xid);
        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));
        SignUtils.sign(request, merchantPrivateKey);
        return OkHttpUtils.doPost(httpClient, baseUrl + "carduser/kyc-link", JSON.toJSONString(request));
    }


    /**
     * cardUserQuery
     */
    public String cardUserQuery(String user_id, String email,
                                String partner_id, String xid, String phone_number) {
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
    public String cardUserUploadKyc(String partner_id, String xid, Individual individual, Document document, Address address) {
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
                            String partner_id, String user_id, String embossed_name) {
        CardApplyRequest request = new CardApplyRequest();
        request.setRequest_id(request_id);
        request.setCard_level(card_level);
        request.setCard_product_id(card_product_id);
        request.setPhone_area_code("86");
        request.setPhone_number("13312345678");
        request.setUser_id(user_id);
        request.setEmbossed_name(embossed_name);

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
    public String updateCardPhone(String card_id, String partner_id, String user_id, String area_code, String phone_no) {
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
    public String cardSensitiveInfoUrl(String card_id, String ip_address, String partner_id, String user_id) {
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
    public String cardChangePin(String card_id, String pin, String partner_id, String user_id) {
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
     * upay 特殊卡段 修改ATM PIN
     */
    @SneakyThrows
    public String specialCardChangePin(String card_id, String pin, String partner_id, String user_id) {
        CardChangePinRequest request = new CardChangePinRequest();
        request.setCard_id(card_id);
        request.setUser_id(user_id);
        request.setCard_pin(RSAUtils.encrypt(pin, platformPublicKey));

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/get-change-pin-model",
                JSON.toJSONString(request));
    }


    /**
     * cardAccountTopUp
     */
    public String cardAccountTopUp(String request_id, String card_id, String currency, String amount, String partner_id, String user_id) {
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
    public String cardAccountTransactions(String request_id, String card_id, String order_no, String partner_id, String user_id, int pageNumber, String tx_status, String tx_type, String detail_id) {
        CardAccountTxnsRequest request = new CardAccountTxnsRequest();
        request.setCard_id(card_id);
        request.setUser_id(user_id);
        request.setRequest_id(request_id);
        request.setOrder_no(order_no);
        request.setPage_number(pageNumber);
        request.setDate_range_from(1592772500847L);
        request.setTx_status(tx_status);
        request.setTx_type(tx_type);
        request.setDetail_id(detail_id);


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
     *
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
     *
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

    /**
     * 替换卡
     */

    public String cardReplace(String user_id, String original_card_id, String replace_reason, String partner_id, String request_id) {
        CardReplaceRequest request = new CardReplaceRequest();
        request.setUser_id(user_id);
        request.setOriginal_card_id(original_card_id);
        request.setReplace_reason(replace_reason);
        request.setRequest_id(request_id);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        System.out.println(request);
        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/replace",
                JSON.toJSONString(request));
    }

    /**
     * 设置卡日限额
     */
    public String limitChange(String partner_id, String user_id, String card_id, BigDecimal daily_purchase_limit) {
        LimitChangeRequest request = new LimitChangeRequest();
        request.setPartner_id(partner_id);
        request.setUser_id(user_id);
        request.setCard_id(card_id);
        request.setDaily_purchase_limit(daily_purchase_limit);

        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/limitChange",
                JSON.toJSONString(request));
    }

    public String txnVerificationConfirm(String partner_id, String user_id, String card_id, String token, String request_id) {
        TxnVerificationConfirmRequest request = new TxnVerificationConfirmRequest();
        request.setPartner_id(partner_id);
        request.setUser_id(user_id);
        request.setCard_id(card_id);
        request.setToken(token);
        request.setRequest_id(request_id);

        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/txn-verification-confirm",
                JSON.toJSONString(request));
    }

    public String emailChange(String user_id,
                              String email, String partner_id, String nonce) {

        EmailChangeRequest request = new EmailChangeRequest();
        request.setUser_id(user_id);
        request.setEmail(email);

        request.setPartner_id(partner_id);
        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(nonce);

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "carduser/change-email",
                JSON.toJSONString(request));
    }


    public String txnVerificationDecline(String partner_id, String user_id, String card_id, String token, String request_id) {
        TxnVerificationDeclineRequest request = new TxnVerificationDeclineRequest();
        request.setPartner_id(partner_id);
        request.setUser_id(user_id);
        request.setCard_id(card_id);
        request.setToken(token);
        request.setRequest_id(request_id);

        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/txn-verification-decline",
                JSON.toJSONString(request));
    }

    public String quotaCreate(String partner_id, String card_product_id, String card_level, String share_quota_name, String remark, String request_id) {
        QuotaCreateRequest request = new QuotaCreateRequest();
        request.setRequest_id(request_id);
        request.setPartner_id(partner_id);
        request.setCard_product_id(card_product_id);
        request.setCard_level(card_level);
        request.setShare_quota_name(share_quota_name);
        request.setRemark(remark);

        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/share-quota/quota/create",
                JSON.toJSONString(request));
    }

    public String quotaFrozen(String share_quota_id, String partner_id, String request_id) {
        QuotaFrozenRequest request = new QuotaFrozenRequest();
        request.setPartner_id(partner_id);
        request.setShare_quota_id(share_quota_id);
        request.setRequest_id(request_id);

        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/share-quota/quota/frozen",
                JSON.toJSONString(request));
    }

    public String quotaUnfrozen(String share_quota_id, String partner_id, String request_id) {
        QuotaFrozenRequest request = new QuotaFrozenRequest();
        request.setShare_quota_id(share_quota_id);
        request.setPartner_id(partner_id);
        request.setRequest_id(request_id);

        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/share-quota/quota/unfrozen",
                JSON.toJSONString(request));
    }

    public String quotaList(String share_quota_id, String limit, String page, String partner_id) {
        QuotaListRequest request = new QuotaListRequest();
        request.setShare_quota_id(share_quota_id);
        request.setLimit(limit);
        request.setPage(page);
        request.setPartner_id(partner_id);

        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/share-quota/quota/list",
                JSON.toJSONString(request));
    }

    public String txAdjustment(String share_quota_id, String amount, String partner_id, String remark, String request_id) {
        TxAdjustmentRequest request = new TxAdjustmentRequest();
        request.setShare_quota_id(share_quota_id);
        request.setAmount(amount);
        request.setPartner_id(partner_id);
        request.setRequest_id(request_id);
        request.setRemark(remark);

        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/share-quota/quota/tx/adjustment",
                JSON.toJSONString(request));
    }

    public String txList(String share_quota_id, String request_id, String strat_time, String end_time, String limit, String page, String partner_id) {
        TxListRequest request = new TxListRequest();
        request.setShare_quota_id(share_quota_id);
        request.setRequest_id(request_id);
        request.setStart_time(strat_time);
        request.setEnd_time(end_time);
        request.setLimit(limit);
        request.setPage(page);
        request.setPartner_id(partner_id);

        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/share-quota/quota/tx/list",
                JSON.toJSONString(request));
    }

    public String quotaCardApply(String share_quota_id, String user_id, String request_id, String card_product_id, String card_level, String phone_number, String phone_area_code, String partner_id,String embossed_name) {
        QuotaCardApplyRequest request = new QuotaCardApplyRequest();
        request.setShare_quota_id(share_quota_id);
        request.setUser_id(user_id);
        request.setRequest_id(request_id);
        request.setCard_product_id(card_product_id);
        request.setCard_level(card_level);
        request.setPhone_number(phone_number);
        request.setPhone_area_code(phone_area_code);
        request.setPartner_id(partner_id);
        request.setEmbossed_name(embossed_name);

        request.setSign_type("RSA");
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));
        request.setNonce(String.valueOf(System.currentTimeMillis()));

        SignUtils.sign(request, merchantPrivateKey);

        return OkHttpUtils.doPost(httpClient, baseUrl + "card/share-quota/apply",
                JSON.toJSONString(request));
    }
}
