package com.muse.demo.test;

import com.muse.demo.MuseClient;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

public class CardApiTest {

    /**
     * private key, please keep it in a safe place
     */
    public static String privateKey =
            "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCnI1kB3OyurSfUaqIc7QPVbehYFeAXz3wRbr0KfL3bkF42r9lKUV5s5S3Bqfwu/L2r8kCFCVg9p6BBEZQFoGNp0LHqYThm89rWfzfFom6hncnUIUu67PYxq2tjazZRj/PxKjaGckPowXe6tbLapV2SiexdXFbW9SlsQQstXQW75aug+PElCYmy4dnv2f7OTF1PAkUTxTR1WNVhWZMRdqozmko3UsWDmT92JSYIzeES2AjktWYNAFrKGv7k/66jVHbieS9JAN6XU5EzBQ1pvlBk3oLHYRk0YKJG9Xrw822OLN8hO/Ty0et7qy/f9C38Nfw4UG4b+ZySZQJ8WbKLJMAbAgMBAAECggEAHRvk5pQpjIqPw0kHDu6gmk1YB+9XZg4213pn5imvj0vnfLLHr0/YmDKZ8369cxmFlyrL3d+wxJwrJun+07QJXGaCdgWUoymZVX42om8VwYQPoKhj3hxjDGeEfn4vqajenYPylxvTg/gd+CCpE7d1Qo5O4juwzCNKoZX6cl4fH4gqUk/yxxzFtUdA3knECmC0SxxesSqKwlKhFPfkLdvH2lBuhojfE+2Yo9AMFz4GfvDA4ds7SYPplm7K/57EA0qE75IBxuCnUIBimMFViZanmh08zbHVdlUcN1fXlxJnyv5dXh65OzLU7t96S1OXsmT3dMpRY4iJkAHdLgKLcRzSQQKBgQDdXtDqgSLV9fv5W9RABfCKlabdO+jzGwglWDQyBtTTioaTMEwY4UIxRm4YR4pXg0QNJnO6ROTcGYKrOJDD+L2WilVgVE4zntsN0Aj3vWLb7Sf/0u87nbU/HydPiSEz8H1AET60oWSXM1MLVaswynBz27QklmTINtskoF6gu3dx8QKBgQDBSLMPDLKawFSU3psRRZVQpHBQQjvkeqBHFDQzeOReQvnExuTQ3F7CE7Vw57+pvyS905sirmwUGfS+1ACqeXVz4Kn9rV2GS930oCBplJQgs7aJK0p0fALvrtL+Qjsga3FDAS8xHPzTDj66NelJI1AOFiUY/VoKwdNn40D4KR3GywKBgCvrBbOgjxK3zJe6Gi/hfclgy0wU+LBSaplOGHzcUhjt4KkO6en9tq4j9O+oMdAO4M9jE46e4HCyNvRVMpNOo/5bz3hfAWzIVVk2LrFHx3cuY8MjTAcd0LmHKrtiz02IprCxOymG43gD3LPg+Sei4hB6RBEGLVRzXaK0llF5H8dhAoGAebfFgym04/1Qhnt03bibIjCbxf8f5m9OtdREV1G/RpkY31F9UQYl6kQtE8/thAEqKxyx6nI6/6Gk3fN2A+T/ER0fD/B4IBVwzhd0sehuK/Xgcps/hQF/e971YkblIzJmHhMF3ADsOiETYYKHyZYiWOybKhSJ+pI7BoY3KNADv2cCgYAWS/XUef5V+R0xnGv6PvPWjT7q/Oa1G1RJ3uSVa3qL2WEWiwJpg+dC6wBTDsx7CRp5X0kodabLUSqCXkaho61AMwgiAgPCwGTXe4dZRs99cgNJjrer9Gcf/CYVA/43tMyuFFSvV794/oZ59nBaF3JyzeZxo3NKUgGpaKIKrlixkg==";
    /**
     * platform public key, please download from musepay partner dashboard
     */
    public static String platformKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvyuW8yKhVc7LxA6Sjte7VpCPPTFgqJJj0x9e7TyjhL8wZt/uFsPtjsQmc/oIerRwIht2AecNZ07DIr23QR7SDRAapiE7UEwy/4va1TTR9vsZCQrTZ+eX7p+ksNFTDYd1+tY8EwJZW3lk9NANK45YvA7Cn1knP+96530F2NjSlbVJepuTMP7nrE+czFkzU8a8bloDN1Oh6SwkeeX//8TuTp4urk9VNscvjEEm4INAW1stNNATdYXqllBAI4d/plHEflSXfHxQVpbV/peEw+NIOoMcVwrXeBW9ZsUhcDVVASraaw7nOW9I7fqJF5uyKenlTORH7z2uoFzYwRXU27G54wIDAQAB";


    private final String baseUrl = "https://api.test.musepay.io/v1/";

    private final MuseClient client = MuseClient.build(baseUrl, privateKey, platformKey);


    @Test
    public void cardApply() {
        String requestId = "APPLY-" + System.currentTimeMillis();
        String respStr = client.cardApply(requestId,
                "1",
                "PD100024400062",
                "2103059",
                "1113059",
                "embossedNameTest"
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
                "2100063",
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

    /**
     * 卡激活
     */
    @Test
    public void cardActivate() {
        String cardId = "VC3708724738696708103";
        String respStr = client.cardActivate(cardId,
                "2100063",
                "1113333"
        );
        System.out.println(respStr);
    }

    /**
     * 实体卡激活
     */
    @Test
    public void physicalCardActivate() {
        String cardId = "VC3545697435218214928";
        String respStr = client.physicalCardActivate(cardId,
                "2000601",
                "1001581"
        );
        System.out.println(respStr);
    }

    @Test
    public void cardLock() {
        String cardId = "VC3334958645719662595";
        String respStr = client.cardLock(cardId,
                "2100063",
                "1111029"
        );
        System.out.println(respStr);
    }

    @Test
    public void cardUnlock() {
        String cardId = "VC3334958645719662595";
        String respStr = client.cardUnlock(cardId,
                "2100063",
                "1111029"
        );
        System.out.println(respStr);
    }

    @Test
    public void cardSensitiveInfoUrl() {
        String cardId = "VC3420929116301131780";
        String respStr = client.cardSensitiveInfoUrl(cardId,
                "103.152.220.46",
                "2100063",
                "1111926"
        );
        System.out.println(respStr);
    }

    /**
     * 修改ATM PIN
     * @throws Exception
     */
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

    /**
     * upay特殊卡段 修改ATM PIN
     * @throws Exception
     */
    @Test
    public void specialCardChangePin() throws Exception {
        String cardId = "VC1218089352690597900";
        String respStr = client.specialCardChangePin(cardId,
                "123456",
                "2000601",
                "1001581"
        );
        System.out.println(respStr);
    }


    @Test
    public void cardReplace() throws Exception {
        String requestId = "Request-" + System.currentTimeMillis();
        String respStr = client.cardReplace(
                "1113059",
                "VC3694128000282951694",
                "测试替换卡",
                "2103059",
                requestId
        );
        System.out.println(respStr);
    }

    @Test
    public void limitChange() throws Exception {
        String respStr = client.limitChange(
                "2103059",
                "1113059",
                "VC3709103657891430414",
                BigDecimal.valueOf(100)
        );
        System.out.println(respStr);

    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void txnVerificationConfirm() throws Exception {
        String respStr = client.txnVerificationConfirm(
                "2100063",
                "1100083",
                "VC2509671471315615749",
                "d1f897451b054f1864a052aa48e36843",
                UUID.randomUUID().toString()
        );
        System.out.println(respStr);
    }


    @Test
    public void txnVerificationDecline() throws Exception {
        String respStr = client.txnVerificationDecline(
                "2100063",
                "1100083",
                "VC2509671471315615749",
                "b5b18b55360e4d9d2ef031a15671b678",
                UUID.randomUUID().toString()
        );
        System.out.println(respStr);
    }

    /**
     * 创建共享额度
     */
    @Test
    public void quotaCreate() throws Exception {
        String requestId = "APPLY-" + System.currentTimeMillis();
        String respStr = client.quotaCreate(
                "2100063",
                "PD100022600002",
                "1",
                "2100063-光子易API资金池-001",
                "123",
                requestId
        );
        System.out.println(respStr);
    }

    /**
     * 暂停开卡-共享额度
     * NORMAL到SUSPEND_OPEN_CARD
     */
    @Test
    public void quotaFrozen() throws Exception {
        String requestId = "APPLY-" + System.currentTimeMillis();
        String respStr = client.quotaFrozen(
                "CP3230851559035109382",
                "2100063",
                requestId

        );
        System.out.println(respStr);
    }

    /**
     * 解冻共享额度
     * SUSPEND_OPEN_CARD 到 NORMAL
     * 超刷：FROZEN 不能解冻
     */
    @Test
    public void quotaUnfrozen() throws Exception {
        String requestId = "APPLY-" + System.currentTimeMillis();
        String respStr = client.quotaUnfrozen(
                "CP3230851559035109382",
                "2100063",
                requestId
        );
        System.out.println(respStr);
    }

    /**
     * 查询共享额度列表
     *
     * @throws Exception
     */
    @Test
    public void quotaList() throws Exception {
        String respStr = client.quotaList(
                "CP3233690772936491020",
                "10",
                "1",
                "2100063"
        );
        System.out.println(respStr);
    }

    /**
     * 共享额度调整
     *
     * @throws Exception
     */
    @Test
    public void txAdjustment() throws Exception {
        String requestId = "APPLY-" + System.currentTimeMillis();
        String respStr = client.txAdjustment(
                "CP3545544053346140160",
                "200",
                "2100063",
                "APi代理商资金池转入-光子易",
                requestId
        );
        System.out.println(respStr);
    }

    /**
     * 查询共享额度交易列表
     *
     * @throws Exception
     */
    @Test
    public void txList() throws Exception {
        String requestId = "APPLY-" + System.currentTimeMillis();
        String respStr = client.txList(
                "CP3230228135941865479",
                "",
                "1751254149000",
                "1782790149000",
                "100",
                "1",
                "2100063"
        );
        System.out.println(respStr);
    }

    /**
     * 申请资金池卡
     *
     * @throws Exception
     */
    @Test
    public void quotaCardApply() throws Exception {
        String requestId = "APPLY-" + System.currentTimeMillis();
        String respStr = client.quotaCardApply(
                "CP3545544053346140160",
                "1111029",
                requestId,
                "PD100022600002",
                "1",
                "17689876878",
                "86",
                "2100063",
                "embossedNamePhotonPay"
        );
        System.out.println(respStr);
    }

}
