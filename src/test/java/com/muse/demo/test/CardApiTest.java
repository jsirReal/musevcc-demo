package com.muse.demo.test;

import com.muse.demo.MuseClient;
import org.junit.jupiter.api.Test;

public class CardApiTest {

    /**
     * private key, please keep it in a safe place
     */
    public static String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCnI1kB3OyurSfUaqIc7QPVbehYFeAXz3wRbr0KfL3bkF42r9lKUV5s5S3Bqfwu/L2r8kCFCVg9p6BBEZQFoGNp0LHqYThm89rWfzfFom6hncnUIUu67PYxq2tjazZRj/PxKjaGckPowXe6tbLapV2SiexdXFbW9SlsQQstXQW75aug+PElCYmy4dnv2f7OTF1PAkUTxTR1WNVhWZMRdqozmko3UsWDmT92JSYIzeES2AjktWYNAFrKGv7k/66jVHbieS9JAN6XU5EzBQ1pvlBk3oLHYRk0YKJG9Xrw822OLN8hO/Ty0et7qy/f9C38Nfw4UG4b+ZySZQJ8WbKLJMAbAgMBAAECggEAHRvk5pQpjIqPw0kHDu6gmk1YB+9XZg4213pn5imvj0vnfLLHr0/YmDKZ8369cxmFlyrL3d+wxJwrJun+07QJXGaCdgWUoymZVX42om8VwYQPoKhj3hxjDGeEfn4vqajenYPylxvTg/gd+CCpE7d1Qo5O4juwzCNKoZX6cl4fH4gqUk/yxxzFtUdA3knECmC0SxxesSqKwlKhFPfkLdvH2lBuhojfE+2Yo9AMFz4GfvDA4ds7SYPplm7K/57EA0qE75IBxuCnUIBimMFViZanmh08zbHVdlUcN1fXlxJnyv5dXh65OzLU7t96S1OXsmT3dMpRY4iJkAHdLgKLcRzSQQKBgQDdXtDqgSLV9fv5W9RABfCKlabdO+jzGwglWDQyBtTTioaTMEwY4UIxRm4YR4pXg0QNJnO6ROTcGYKrOJDD+L2WilVgVE4zntsN0Aj3vWLb7Sf/0u87nbU/HydPiSEz8H1AET60oWSXM1MLVaswynBz27QklmTINtskoF6gu3dx8QKBgQDBSLMPDLKawFSU3psRRZVQpHBQQjvkeqBHFDQzeOReQvnExuTQ3F7CE7Vw57+pvyS905sirmwUGfS+1ACqeXVz4Kn9rV2GS930oCBplJQgs7aJK0p0fALvrtL+Qjsga3FDAS8xHPzTDj66NelJI1AOFiUY/VoKwdNn40D4KR3GywKBgCvrBbOgjxK3zJe6Gi/hfclgy0wU+LBSaplOGHzcUhjt4KkO6en9tq4j9O+oMdAO4M9jE46e4HCyNvRVMpNOo/5bz3hfAWzIVVk2LrFHx3cuY8MjTAcd0LmHKrtiz02IprCxOymG43gD3LPg+Sei4hB6RBEGLVRzXaK0llF5H8dhAoGAebfFgym04/1Qhnt03bibIjCbxf8f5m9OtdREV1G/RpkY31F9UQYl6kQtE8/thAEqKxyx6nI6/6Gk3fN2A+T/ER0fD/B4IBVwzhd0sehuK/Xgcps/hQF/e971YkblIzJmHhMF3ADsOiETYYKHyZYiWOybKhSJ+pI7BoY3KNADv2cCgYAWS/XUef5V+R0xnGv6PvPWjT7q/Oa1G1RJ3uSVa3qL2WEWiwJpg+dC6wBTDsx7CRp5X0kodabLUSqCXkaho61AMwgiAgPCwGTXe4dZRs99cgNJjrer9Gcf/CYVA/43tMyuFFSvV794/oZ59nBaF3JyzeZxo3NKUgGpaKIKrlixkg==";
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
                "PD100000900001",
                "2100063",
                "1104553"
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

    @Test
    public void cardReplace() throws Exception {
        String respStr = client.cardReplace(
                "1104553",
                "VC2241764124477947918",
                "测试替换卡",
                "2100063"
        );
        System.out.println(respStr);
    }
}
