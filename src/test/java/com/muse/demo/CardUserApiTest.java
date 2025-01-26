package com.muse.demo;

import com.muse.demo.dto.Address;
import com.muse.demo.dto.Document;
import com.muse.demo.dto.Individual;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Random;


@Slf4j
public class CardUserApiTest extends BaseTest {

    @Test
    public void cardUserCreate() {
        Individual individual = new Individual();
        individual.setLast_name("TimApi12");
        individual.setFirst_name("ZhouAPi12");
        individual.setDate_of_birth("1990-10-10");
        individual.setOccupation("aaa");
        individual.setAnnual_income("100000");
        Document document = new Document();
        document.setType("1");
        document.setFront("data:image/jpeg;base64,iVBORw0KGgoAAAANSUhEUgAAAZAAAAGQAQAAAACoxAthAAAEMElEQVR42u1cS27lMAyTVzlGbprk3TTHyCqeiKTy60OB2c1Aeihe3cD0QrAkUlJq/a8/VpCCFKQgBfmnIJsdn9b7fvwa1rn3z2bTcHyPu437seirDX3xXWNBAPGFNti4HM83m7tj/XlfDziA2lmQY3Fs+7iRj2/sPCDxcKF53ebWCnKHHFcRt+5u1Y9bW08K8s3I7siTw0caduefHScU5O3IHu7k0cPaOozMK3qtC3JLFpvb9pefL/klLUSf1ZBMd08WCHpcbIqK3zhMVogb2W04YY8vhhUUxb14hzu7g/tPQWjklRHPsaJwYCZucEMk9GzbafaCIKB9YGdAOjfsjtU5pMFGFleQ08jQBVAEq5tUOVcCgU8KckJmxTpPGXJk6im4cwMQZi/ISUh0CUVFtjGUFBwZZ/ZIGQXBftzJEAXhyB3i3RfgwH5aQSQTPFnQnj3U6JEvDv/1nRaOvAwFESGh0nwQElzLRYf05QeHSQ3x4OZi80ZIcAi8e0bFgza/yYTsEIvS0BXxQEgaLyeJ8YuQZIaAv9FtoxDkC1YjY/EkJNkhHvqoFFjWhsPirj6KbA9CkhtikyLbkVjtLqz6WcsNGlwQO4tmICGT8155LoLe2r5rsdyQHtUM7Ddo9sPaTRHPZcKbkKSHNN+w2iWsUOLmIe7Ffqa9CElmiJM3+rLiGwiJn0DXppxXL68gas8xwwYtQU2yietGz84eGTk5JASCp1dUP7Afh7BxMNmbw6SGUEBh20dXlOU1f76QnEDa33w/OcSfRD5lL3jkd0fcaz8JSXaIlIK6Tgx3pjw7ScU/HTk7hGaU8/au1vlicm149JvCpYbAeRsMO0eBaGabAClDDfS7I2eHxGTLvWE3rFT0TK+7bulYkHNUA5eQ3eGRCZeVNEY/1I4ehe7cEANto5iKWSl3Z5SM1GH/ol7zQtiwU9FM6qDRvBb1200Ft4KcrQFPCgPpxzVDRc9d1FV5DLfkhkQREsVtpQzYtkUJN8ZEC3LJhA5CsqsjALEgLPvFVKYFCcigkYzb4MGq6HcNb9jcCyKIeuW6mZpyYTGNworlo7uwSg4heZuGaGiigdJCjZ6J9a3FUkMuR8bNHBfqKVxICquXI+eGrJrHQFN40fCnXgE4u8OfhyNnh5z1/7lHOeiSnwx9IC2PWYXEEHHd8SRsrZOZjD16nZxGuGux3BAzNdDZypTzUrPLr8+6R0FisJ9TsjFApRe+llOBsnxUkPtLExsVuhp2UZAkwaNTj/vrNZO0EL2Yo17wlWRDn0K5q9tSkOvlL5XOlCyuae1BMfA1QJUcEg07MZMpYh0m9PyQ9nLkghhf8nq9CyBaoubmFyMnh5jmMWKumNNTLWYd3yW13JB+DpXRklsYmYOgMdzyKcgzWQR5s3MuaIkBqrm/B6hSQ+p/qhSkIAUpyH8L+QM8qRjL2c9mRwAAAABJRU5ErkJggg==");
        document.setBack("");
        document.setNumber("123");
        document.setCountry("CN");
        document.setExpiry_date("2035-10-10");

        String respStr = client.cardUserCreate("Tim-api-10",
                "hjojggbu.dev@musepay.io",
                partnerId,
                "10017",
                individual,
                document
        );
        log.info(respStr);
    }



    @Test
    public void pollingUserQuery(String xid) throws InterruptedException {
        while (true) {
            String respStr = client.cardUserQuery(null,
                    "",
                    partnerId,
                    xid,
                    ""
            );
            System.out.println(respStr);
            Thread.sleep(3000);
        }

    }

    @Test
    public void cardUserQuery() {
        String respStr = client.cardUserQuery(null,
                "",
                partnerId,
                "10017",
                ""
        );
        System.out.println(respStr);
    }

    @Test
    public void cardUserKycUpload() {
        Individual individual = new Individual();
        individual.setLast_name("TimApi9");
        individual.setFirst_name("ZhouAPi9");
        individual.setDate_of_birth("1982-10-10");
        individual.setOccupation("aaa");
        individual.setAnnual_income("100000");


        Document document = new Document();
        document.setType("1");
        document.setFront("data:image/jpeg;base64,iVBORw0KGgoAAAANSUhEUgAAAZAAAAGQAQAAAACoxAthAAAEMElEQVR42u1cS27lMAyTVzlGbprk3TTHyCqeiKTy60OB2c1Aeihe3cD0QrAkUlJq/a8/VpCCFKQgBfmnIJsdn9b7fvwa1rn3z2bTcHyPu437seirDX3xXWNBAPGFNti4HM83m7tj/XlfDziA2lmQY3Fs+7iRj2/sPCDxcKF53ebWCnKHHFcRt+5u1Y9bW08K8s3I7siTw0caduefHScU5O3IHu7k0cPaOozMK3qtC3JLFpvb9pefL/klLUSf1ZBMd08WCHpcbIqK3zhMVogb2W04YY8vhhUUxb14hzu7g/tPQWjklRHPsaJwYCZucEMk9GzbafaCIKB9YGdAOjfsjtU5pMFGFleQ08jQBVAEq5tUOVcCgU8KckJmxTpPGXJk6im4cwMQZi/ISUh0CUVFtjGUFBwZZ/ZIGQXBftzJEAXhyB3i3RfgwH5aQSQTPFnQnj3U6JEvDv/1nRaOvAwFESGh0nwQElzLRYf05QeHSQ3x4OZi80ZIcAi8e0bFgza/yYTsEIvS0BXxQEgaLyeJ8YuQZIaAv9FtoxDkC1YjY/EkJNkhHvqoFFjWhsPirj6KbA9CkhtikyLbkVjtLqz6WcsNGlwQO4tmICGT8155LoLe2r5rsdyQHtUM7Ddo9sPaTRHPZcKbkKSHNN+w2iWsUOLmIe7Ffqa9CElmiJM3+rLiGwiJn0DXppxXL68gas8xwwYtQU2yietGz84eGTk5JASCp1dUP7Afh7BxMNmbw6SGUEBh20dXlOU1f76QnEDa33w/OcSfRD5lL3jkd0fcaz8JSXaIlIK6Tgx3pjw7ScU/HTk7hGaU8/au1vlicm149JvCpYbAeRsMO0eBaGabAClDDfS7I2eHxGTLvWE3rFT0TK+7bulYkHNUA5eQ3eGRCZeVNEY/1I4ehe7cEANto5iKWSl3Z5SM1GH/ol7zQtiwU9FM6qDRvBb1200Ft4KcrQFPCgPpxzVDRc9d1FV5DLfkhkQREsVtpQzYtkUJN8ZEC3LJhA5CsqsjALEgLPvFVKYFCcigkYzb4MGq6HcNb9jcCyKIeuW6mZpyYTGNworlo7uwSg4heZuGaGiigdJCjZ6J9a3FUkMuR8bNHBfqKVxICquXI+eGrJrHQFN40fCnXgE4u8OfhyNnh5z1/7lHOeiSnwx9IC2PWYXEEHHd8SRsrZOZjD16nZxGuGux3BAzNdDZypTzUrPLr8+6R0FisJ9TsjFApRe+llOBsnxUkPtLExsVuhp2UZAkwaNTj/vrNZO0EL2Yo17wlWRDn0K5q9tSkOvlL5XOlCyuae1BMfA1QJUcEg07MZMpYh0m9PyQ9nLkghhf8nq9CyBaoubmFyMnh5jmMWKumNNTLWYd3yW13JB+DpXRklsYmYOgMdzyKcgzWQR5s3MuaIkBqrm/B6hSQ+p/qhSkIAUpyH8L+QM8qRjL2c9mRwAAAABJRU5ErkJggg==");
        document.setBack("");
        document.setNumber("123");
        document.setCountry("CN");
        document.setExpiry_date("2035-10-10");


        String respStr = client.cardUserUploadKyc(
                "2100063",
                "10009",
                individual,
                document,
                new Address()
        );
        System.out.println(respStr);
    }
}
