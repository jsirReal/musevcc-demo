package com.muse.demo;

import org.junit.jupiter.api.Test;

public class CardApiTest {

    /**
     * private key, please keep it in a safe place
     */
    public static String privateKey = "";
    /**
     * platform public key, please download from musepay partner dashboard
     */
    public static String platformKey = "";

    private final String baseUrl = "https://api.dev01.musepay.io/v1/";

    private final MuseClient client = MuseClient.build(baseUrl, privateKey, platformKey);


    @Test
    public void cardApply() {
        String requestId = "APPLY-"+ System.currentTimeMillis();
        String respStr = client.cardApply(requestId,
                "1",
                "PD100003500001",
                "2000601",
                "1001581"
                );
        System.out.println(respStr);
    }

    @Test
    public void cardApplyResult() {

        String respStr = client.cardApplyResult("APPLY-1692689464479",
                "202316926894664191218089352690597897",
                "2000601",
                "1001581"
        );
        System.out.println(respStr);
    }

    @Test
    public void cardQuery() {
        String cardId = "VC1218089352690597900";
        String respStr = client.cardQuery(cardId,
                "2000601",
                "1001581"
        );
        System.out.println(respStr);
    }

    @Test
    public void updateCardPhone() {
        String cardId = "VC1235902506176937990";
        String respStr = client.updateCardPhone(cardId,
                "2100063",
                "1100083",
                "86",
                "16665555551"
        );
        System.out.println(respStr);
    }

    @Test
    public void cardActivate() {
        String cardId = "VC1218089352690597900";
        String respStr = client.cardActivate(cardId,
                "2000601",
                "1001581"
        );
        System.out.println(respStr);
    }

    @Test
    public void physicalCardActivate() {
        String cardId = "VC1218089352690597900";
        String respStr = client.physicalCardActivate(cardId,
                "2000601",
                "1001581"
        );
        System.out.println(respStr);
    }

    @Test
    public void cardLock() {
        String cardId = "VC1218089352690597900";
        String respStr = client.cardLock(cardId,
                "2000601",
                "1001581"
        );
        System.out.println(respStr);
    }
    @Test
    public void cardUnlock() {
        String cardId = "VC1218089352690597900";
        String respStr = client.cardUnlock(cardId,
                "2000601",
                "1001581"
        );
        System.out.println(respStr);
    }

    @Test
    public void cardSensitiveInfoUrl() {
        String cardId = "VC1218089352690597900";
        String respStr = client.cardSensitiveInfoUrl(cardId,
                "211.21.6.181",
                "2000601",
                "1001581"
        );
        System.out.println(respStr);
    }

    @Test
    public void cardChangePin() throws Exception {
        String cardId = "VC1218089352690597900";
        String respStr = client.cardChangePin(cardId,
                "123456",
                "2000601",
                "1001581"
        );
        System.out.println(respStr);
    }
}
