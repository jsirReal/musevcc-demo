package com.muse.demo.test;

import com.muse.demo.MuseClient;
import com.muse.demo.dto.Address;
import com.muse.demo.dto.Document;
import com.muse.demo.dto.Individual;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;


@Slf4j
public class CardUserApiTest {

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
    public void cardUserCreate() {

        Individual individual = new Individual();
        individual.setLast_name("TimApi16");
        individual.setFirst_name("ZhouAPi16");
        individual.setDate_of_birth("1990-10-10");
        individual.setOccupation("aaa");
        individual.setAnnual_income("100000");


        Document document = new Document();
        document.setType("1");
        document.setFront("data:image/jpeg;base64,iVBORw0KGgoAAAANSUhEUgAAAZAAAAGQAQAAAACoxAthAAAEMElEQVR42u1cS27lMAyTVzlGbprk3TTHyCqeiKTy60OB2c1Aeihe3cD0QrAkUlJq/a8/VpCCFKQgBfmnIJsdn9b7fvwa1rn3z2bTcHyPu437seirDX3xXWNBAPGFNti4HM83m7tj/XlfDziA2lmQY3Fs+7iRj2/sPCDxcKF53ebWCnKHHFcRt+5u1Y9bW08K8s3I7siTw0caduefHScU5O3IHu7k0cPaOozMK3qtC3JLFpvb9pefL/klLUSf1ZBMd08WCHpcbIqK3zhMVogb2W04YY8vhhUUxb14hzu7g/tPQWjklRHPsaJwYCZucEMk9GzbafaCIKB9YGdAOjfsjtU5pMFGFleQ08jQBVAEq5tUOVcCgU8KckJmxTpPGXJk6im4cwMQZi/ISUh0CUVFtjGUFBwZZ/ZIGQXBftzJEAXhyB3i3RfgwH5aQSQTPFnQnj3U6JEvDv/1nRaOvAwFESGh0nwQElzLRYf05QeHSQ3x4OZi80ZIcAi8e0bFgza/yYTsEIvS0BXxQEgaLyeJ8YuQZIaAv9FtoxDkC1YjY/EkJNkhHvqoFFjWhsPirj6KbA9CkhtikyLbkVjtLqz6WcsNGlwQO4tmICGT8155LoLe2r5rsdyQHtUM7Ddo9sPaTRHPZcKbkKSHNN+w2iWsUOLmIe7Ffqa9CElmiJM3+rLiGwiJn0DXppxXL68gas8xwwYtQU2yietGz84eGTk5JASCp1dUP7Afh7BxMNmbw6SGUEBh20dXlOU1f76QnEDa33w/OcSfRD5lL3jkd0fcaz8JSXaIlIK6Tgx3pjw7ScU/HTk7hGaU8/au1vlicm149JvCpYbAeRsMO0eBaGabAClDDfS7I2eHxGTLvWE3rFT0TK+7bulYkHNUA5eQ3eGRCZeVNEY/1I4ehe7cEANto5iKWSl3Z5SM1GH/ol7zQtiwU9FM6qDRvBb1200Ft4KcrQFPCgPpxzVDRc9d1FV5DLfkhkQREsVtpQzYtkUJN8ZEC3LJhA5CsqsjALEgLPvFVKYFCcigkYzb4MGq6HcNb9jcCyKIeuW6mZpyYTGNworlo7uwSg4heZuGaGiigdJCjZ6J9a3FUkMuR8bNHBfqKVxICquXI+eGrJrHQFN40fCnXgE4u8OfhyNnh5z1/7lHOeiSnwx9IC2PWYXEEHHd8SRsrZOZjD16nZxGuGux3BAzNdDZypTzUrPLr8+6R0FisJ9TsjFApRe+llOBsnxUkPtLExsVuhp2UZAkwaNTj/vrNZO0EL2Yo17wlWRDn0K5q9tSkOvlL5XOlCyuae1BMfA1QJUcEg07MZMpYh0m9PyQ9nLkghhf8nq9CyBaoubmFyMnh5jmMWKumNNTLWYd3yW13JB+DpXRklsYmYOgMdzyKcgzWQR5s3MuaIkBqrm/B6hSQ+p/qhSkIAUpyH8L+QM8qRjL2c9mRwAAAABJRU5ErkJggg==");
        document.setBack("");
        document.setNumber("123456");
        document.setCountry("CN");
        document.setExpiry_date("2035-10-10");


        String respStr = client.cardUserCreate("Tim-api-16",
                "ztmsdu1238@snapmail.cc",
                "2100063",
                "100021",
                individual,
                document
        );
        System.out.println(respStr);
    }

    @Test
    public void cardUserCreateWithKYCLink() {

        String respStr = client.cardUserCreateWithKYCLink("kyc-202503040001",
                "ztmsdu030401@snapmail.cc",
                "2100063",
                "202503040001"
        );
        System.out.println(respStr);
    }

    @Test
    public void generateKycLink() {
        String xid = "202501220002";
        log.info("XID：{}", xid);
        String respStr = client.generateKycLink(xid, "2100063");

        log.info("generateKycLink resp: {}", respStr);
    }

    @Test
    public void cardUserQuery() {

        Individual individual = new Individual();
        Document document = new Document();
        String respStr = client.cardUserQuery("1107523",
                "",
                "2100063",
                "10014",
                ""
        );
        System.out.println(respStr);
    }

    @Test
    public void cardUserKycUpload() throws Exception {

        Individual individual = new Individual();
        individual.setLast_name("TimApi9test");
        individual.setFirst_name("ZhouAPi9test");
        individual.setDate_of_birth("1992-10-10");
        individual.setOccupation("bbb");
        individual.setAnnual_income("1023500");

        BufferedReader reader = new BufferedReader(
                new FileReader(new File("/Users/zhoutianmu/Desktop/img_base64.txt"))
        );


        Document document = new Document();
        document.setType("1");
        document.setFront(reader.readLine());
        document.setBack("");
        document.setNumber("98789789876");
        document.setCountry("CN");
        document.setExpiry_date("2035-10-10");


        String respStr = client.cardUserUploadKyc(
                "2100063",
                "10001",
                individual,
                document,
                new Address()
        );
        System.out.println(respStr);
    }

    @Test
    public void emailChange() {
        String respStr = client.emailChange("1107523",
                "ztmsdulv12@snapmail.cc",
                "2100063",
                String.valueOf(System.currentTimeMillis()));
        System.out.println(respStr);
    }

}
