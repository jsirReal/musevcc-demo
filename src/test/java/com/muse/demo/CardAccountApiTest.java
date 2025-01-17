package com.muse.demo;

import org.junit.jupiter.api.Test;

public class CardAccountApiTest extends BaseTest {

    @Test
    public void cardAccountTopUp() {
        String requestId = "APPLY-" + System.currentTimeMillis();
        String respStr = client.cardAccountTopUp(requestId,
                "VC1235902506176937990",
                "USDT",
                "8",
                partnerId,
                "1100083"
        );
        System.out.println(respStr);
    }

    @Test
    public void cardAccountTransactions() {

        String requestId = "APPLY-" + System.currentTimeMillis();
        String respStr = client.cardAccountTransactions("",
                "VC1235902506176937990",
                "202316932773351761238288377689735176",
                "2100063",
                "1100083",
                1,
                "",
                "",
                ""
        );
        System.out.println(respStr);

    }


}
