package com.muse.demo;

import org.junit.jupiter.api.Test;


public class PartnerApiTest extends BaseTest {

    @Test
    public void queryPartnerBalance() {
        String respStr = client.queryPartnerBalance("USDT_BSC_TEST",
                partnerId);
        System.out.println(respStr);
    }

    @Test
    public void queryPartnerAddress() {
        String respStr = client.queryPartnerAddress("USDT_BSC_TEST",
                partnerId,
                "");
        System.out.println(respStr);
    }
}
