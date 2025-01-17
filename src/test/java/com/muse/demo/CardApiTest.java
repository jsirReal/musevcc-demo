package com.muse.demo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

public class CardApiTest extends BaseTest {

    @Test
    public void cardApply() {
        String requestId = "APPLY-" + System.currentTimeMillis();
        String respStr = client.cardApply(requestId,
                "1",
                "PD100000900001",
                "2100063",
                "1100083"
        );
        System.out.println(respStr);
    }

    @Test
    public void cardApplyResult() {

        String respStr = client.cardApplyResult("11111222223",
                "202417303595327992512422964804419590",
                "2100063",
                "1100083"
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
        String cardId = "VC2509671471315615749";
        String respStr = client.cardActivate(cardId,
                "2100063",
                "1100083"
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
                "2100063",
                "1001581"
        );
        System.out.println(respStr);
    }

    @Test
    public void cardUnlock() {
        String cardId = "VC2512422964804419589";
        String respStr = client.cardUnlock(cardId,
                "2100063",
                "1100083"
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

    @Test
    public void cardReplace() throws Exception {
        String respStr = client.cardReplace(
                "1100083",
                "VC2509594299343241228",
                "测试替换卡",
                "2100063",
                "11111222223"
        );
        System.out.println(respStr);
    }

    @Test
    public void limitChange() throws Exception {
        String respStr = client.limitChange(
                "2100063",
                "1101549",
                "VC1803055171025731588",
                BigDecimal.valueOf(123)
        );
        System.out.println(respStr);

    }

    @Test
    public void txnVerificationConfirm() throws Exception{
        String respStr =client.txnVerificationConfirm(
                "2100063",
                "1100083",
                "VC2509671471315615749",
                "88e674501931da8df225569e86e00afa",
                UUID.randomUUID().toString()
        );
        System.out.println(respStr);
    }


    @Test
    public void txnVerificationDecline() throws Exception{
        String respStr=client.txnVerificationDecline(
                "2100063",
                "1100083",
                "VC2509671471315615749",
                "88e674501931da8df225569e86e00afa",
                UUID.randomUUID().toString()
        );
        System.out.println(respStr);
    }
}
